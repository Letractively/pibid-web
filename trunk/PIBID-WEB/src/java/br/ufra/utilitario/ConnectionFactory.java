/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AlanmLira
 */
public class ConnectionFactory {

    private static Connection conn;

    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("<<<<<<<<<<<<<<<<<<CONEXAO BD RELATORIOS>>>>>>>>>>>>>>>>>>>");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/pibid", "root", "root");
                  //      "jdbc:mysql://localhost:3306/lacibufr_pibid", "lacibufr_root", "831645");
                return conn;
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
