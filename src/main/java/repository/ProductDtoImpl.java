package repository;

import dto.ProductDto;
import entity.Product;

import java.sql.*;

public class ProductDtoImpl implements ProductDto {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/empresa";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    private void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("ERROR: failed to load mysql driver");
            e.printStackTrace();
        }
    }


    @Override
    public void insert(Product product) {
        Connection conn = null;

        try {
            registerDriver();
            //Abrir conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conexion Abierta");

            try (Statement stmt = conn.createStatement()) {
                //enviar comando insert
                stmt.executeUpdate("INSERT INTO products VALUES ('" + product.getId() +"','"+ product.getName() +"','" + product.getPrice() +"');");
                System.out.println(" Insertado: INSERT INTO products VALUES ('"
                        + product.getId() + "',´"
                        + product.getName() + "','"
                        + product.getPrice() + "');");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Product read(Integer id) {
        Connection conn = null;
        Product product = null;

        try {
            registerDriver();
            // abrir la conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conexion Abierta");
            // consulta select (selecciona el producto con ID especificado)
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from products where id = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, id);
                // ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Product
                        product = new Product(id,
                                rs.getString("name"),
                                rs.getDouble("price"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return product;

    }
}
