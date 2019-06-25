package bimestre02.aep02.repository;

import bimestre02.aep02.entity.BilheteAereo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilheteAereoRepository extends AbstractRepository<BilheteAereo> {
    @Override
    void inserirSql(Connection connection, BilheteAereo objeto) {
        String sql = "insert into BilheteAereo(id, voo, destino, origem, data) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,objeto.getId());
            preparedStatement.setInt(2,objeto.getVoo());
            preparedStatement.setString(3,objeto.getDestino());
            preparedStatement.setString(4,objeto.getOrigem());
            preparedStatement.setDate(5, (Date) objeto.getData());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void criaTabela(Connection connection) {
        String sql =    "create table if not exists BilheteAereo (" +
                        "id integer not null primary key," +
                        "destino varchar(40) not null," +
                        "origem varchar(40) not null," +
                        "voo integer not null," +
                        "data date not null" +
                        ")";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    List<BilheteAereo> obterTodasSql(Connection connection) {
        List<BilheteAereo> cores = new ArrayList<>();

        String sql = "select id, voo, destino, origem, data from BilheteAereo";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int voo = resultSet.getInt("voo");
                String destino = resultSet.getString("destino");
                String origem = resultSet.getString("origem");
                Date date = resultSet.getDate("data");

                cores.add(new BilheteAereo(id, voo, origem, destino, date));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cores;
    }

    @Override
    void alterarSql(Connection connection, BilheteAereo objeto) {
        String sql = "update BilheteAereo set voo = ?, destino = ?, origem = ?, data = ? where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,objeto.getVoo());
            statement.setString(2,objeto.getDestino());
            statement.setString(3,objeto.getOrigem());
            statement.setDate(4, (Date) objeto.getData());
            statement.setInt(5,objeto.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void excluirSql(Connection connection, int id) {
        String sql = "delete from BilheteAereo where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void excluirTodosSql(Connection connection) {
        String sql = "delete from BilheteAereo";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}