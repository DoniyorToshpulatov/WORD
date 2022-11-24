package org.example.repository;

import org.example.db.Database;
import org.example.dto.Word;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class WordRepository {
    public int addWordRepository(Word word) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert  into word(name,translate,description) " +
                            "values (?,?,?)");
            preparedStatement.setString(1, word.getName());
            preparedStatement.setString(2, word.getTranslate());
            preparedStatement.setString(3, word.getDescription());
            int n = preparedStatement.executeUpdate();
            return n;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    public Word getWord(Word word) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from  word where  name=?");
            preparedStatement.setString(1, word.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Word word1 = new Word();
                word1.setId(resultSet.getInt("id"));
                word1.setName(resultSet.getString("name"));
                word1.setTranslate(resultSet.getString("translate"));
                word1.setDescription(resultSet.getString("description"));
                return word;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public List<Word> getAllWord() {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from  word");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Word> words = new LinkedList<>();
            while (resultSet.next()) {
                Word word = new Word();
                word.setId(resultSet.getInt("id"));
                word.setName(resultSet.getString("name"));
                word.setTranslate(resultSet.getString("translate"));
                word.setDescription(resultSet.getString("description"));
                words.add(word);
            }
            return words;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public List<Word> getSearchWord(String part) {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from word where name ilike ('%" + part +"%') or translate ilike ('%" + part + "%' )";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Word> words = new LinkedList<>();
            while (resultSet.next()) {
                Word word = new Word();
                word.setId(resultSet.getInt("id"));
                word.setName(resultSet.getString("name"));
                word.setTranslate(resultSet.getString("translate"));
                word.setDescription(resultSet.getString("description"));
                words.add(word);
            }
            return words;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    public int deleteWord(int id){
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from word where id=?");
            preparedStatement.setInt(1,id);
            int resultSet=preparedStatement.executeUpdate();

           return resultSet;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
}
