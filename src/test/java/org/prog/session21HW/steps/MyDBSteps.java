package org.prog.session21HW.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MyDBSteps {
    public static Connection connection;

    @When("I check these phones in DB")
    public void checkPhonesInDB() throws SQLException {
        for (int i = 0; i < MyGoogleSteps.models.size(); i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM phones WHERE model = ?"
            );
            preparedStatement.setString(1, MyGoogleSteps.models.get(i));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String dbPrice = resultSet.getString("price");
                if (!MyGoogleSteps.prices.get(i).equals(dbPrice)) {
                    throw new RuntimeException("Price mismatch");
                }
            } else {
                System.out.println("ENTER ELSE");
                PreparedStatement insertStatement = connection.prepareStatement(
                        "INSERT INTO phones (model, price)" +
                                "VALUES (?, ?);"
                );
                insertStatement.setString(1, MyGoogleSteps.models.get(i));
                insertStatement.setString(2, MyGoogleSteps.prices.get(i));
                insertStatement.execute();
                System.out.println("INSERT DONE");

            }
        }

    }


    @Then("Prices should match or be saved")
    public void checkResult() throws SQLException {
        for (int i = 0; i < MyGoogleSteps.models.size(); i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM phones WHERE model = ?"
            );
            preparedStatement.setString(1, MyGoogleSteps.models.get(i));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Phone not found in DB");
            }

            String dbPrice = resultSet.getString("price");
            if (!MyGoogleSteps.prices.get(i).equals(dbPrice))
                throw new RuntimeException("Price mismatch");
        }

    }
}


