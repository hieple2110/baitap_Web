package com.hiep.dao;


import com.hiep.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MissDao extends DaoHelper implements BaseDao<Miss> {
    private final String SELECT_ALL = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            " inner join province on miss.idProvince = province.idProvince \n" +
            " inner join nation on miss.idNation = nation.idNation\n" +
            "  inner join education on miss.idEducation = education.idEducation  and miss.isDelete = 0";

    private final String FIND_BY_ID = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            " inner join province on miss.idProvince = province.idProvince \n" +
            " inner join nation on miss.idNation = nation.idNation\n" +
            " inner join education on miss.idEducation = education.idEducation and miss.idMiss = ?";

    private final String LIST_DUYET = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            "inner join province on miss.idProvince = province.idProvince \n" +
            "inner join nation on miss.idNation = nation.idNation\n" +
            "inner join education on miss.idEducation = education.idEducation and (miss.status = \"Đã duyệt\" and miss.isDelete = 0);";

    private final String LIST_CHO_DUYET = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            "inner join province on miss.idProvince = province.idProvince \n" +
            "inner join nation on miss.idNation = nation.idNation\n" +
            "inner join education on miss.idEducation = education.idEducation and (miss.status = \"Chờ duyệt\" and miss.isDelete = 0);";

    private final String LIST_LOAI = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            "inner join province on miss.idProvince = province.idProvince \n" +
            "inner join nation on miss.idNation = nation.idNation\n" +
            "inner join education on miss.idEducation = education.idEducation and (miss.status = \"Bị loại\" and miss.isDelete = 0);";

    private final String INSERT_MISS = "INSERT INTO miss ( nameMiss , dateOfBirth , passport , address , job , email , numberPhone , idProvince , idNation , idEducation , image ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private final String UPDATE_MISS = "UPDATE miss SET nameMiss = ?,dateOfBirth = ?,passport = ?,address = ?,job = ?,email = ?,numberPhone = ?," +
            "idProvince = ?,idNation = ?,idEducation = ?,image = ? ,status = ? WHERE idMiss = ?";

    private final String DELETE_MISS = "UPDATE miss SET isDelete = 1 WHERE idMiss = ?;";

    private final String DELETE_MISS_PROVINCE = "UPDATE miss SET isDelete = 1 WHERE idProvince = ?;";
    private final String DELETE_MISS_NATION = "UPDATE miss SET isDelete = 1 WHERE idNation = ?;";
    private final String DELETE_MISS_EDUCATION = "UPDATE miss SET isDelete = 1 WHERE idEducation = ?;";
    private final String list_page = "select miss.* , province.nameProvince as province, nation.nameNation as nation, education.nameEducation as education from miss\n" +
            " inner join province on miss.idProvince = province.idProvince \n" +
            " inner join nation on miss.idNation = nation.idNation\n" +
            "  inner join education on miss.idEducation = education.idEducation  and miss.isDelete = 0 limit ?,10";


    public List<Miss> listPage( int total) throws SQLException {
        List<Miss> listPage = new ArrayList<>();
        connection();
        PreparedStatement statement = connec.prepareStatement(list_page);
        statement.setInt(1, total*10-10);
        try {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listPage.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPage;
    }

    public int getNumberPage() throws SQLException {
        String query = "select count(*) from miss;";
        connection();
        PreparedStatement preparedStatement = connec.prepareStatement(query);
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 10;
                if (total % 10 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } finally {

        }
        return 0;
    }

    @Override
    public List<Miss> getAll() throws SQLException {
        List<Miss> listMiss = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listMiss.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listMiss;
    }

    @Override
    public void insert(Miss miss) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_MISS)) {
            statement.setString(1, miss.getNameMiss());
            statement.setDate(2, miss.getDateOfBirth());
            statement.setString(3, miss.getPassPort());
            statement.setString(4, miss.getAddress());
            statement.setString(5, miss.getJob());
            statement.setString(6, miss.getEmail());
            statement.setString(7, miss.getNumberPhone());
            statement.setInt(8, miss.getIdProvince());
            statement.setInt(9, miss.getIdNation());
            statement.setInt(10, miss.getIdEducational());
            statement.setString(11, miss.getImage());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Miss miss) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_MISS)) {
            statement.setString(1, miss.getNameMiss());
            statement.setDate(2, miss.getDateOfBirth());
            statement.setString(3, miss.getPassPort());
            statement.setString(4, miss.getAddress());
            statement.setString(5, miss.getJob());
            statement.setString(6, miss.getEmail());
            statement.setString(7, miss.getNumberPhone());
            statement.setInt(8, miss.getIdProvince());
            statement.setInt(9, miss.getIdNation());
            statement.setInt(10, miss.getIdEducational());
            statement.setString(11, miss.getImage());
            statement.setString(12, miss.getStatus());
            statement.setInt(13, id);
            rowUp = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowUp;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDel = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(DELETE_MISS)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    public boolean delete_miss_province(int id) throws SQLException {
        boolean rowDel = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(DELETE_MISS_PROVINCE)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    public boolean delete_miss_nation(int id) throws SQLException {
        boolean rowDel = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(DELETE_MISS_NATION)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    public boolean delete_miss_education(int id) throws SQLException {
        boolean rowDel = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(DELETE_MISS_EDUCATION)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    @Override
    public Miss findById(int id) throws SQLException {
        Miss miss = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idMiss = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                miss = new Miss(idMiss, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return miss;
    }

    public List<Miss> listSearch(String name) throws SQLException {
        List<Miss> listSearchName = new ArrayList<>();
        connection();
        try {
            String query =SELECT_ALL + " and miss.nameMiss like '%" + name + "%'";
            PreparedStatement statement = connec.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listSearchName.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listSearchName;
    }

    public List<Miss> listMissDuyet() throws SQLException {
        List<Miss> listDuyet = new ArrayList<>();
        connection();
        try {
            PreparedStatement statement = connec.prepareStatement(LIST_DUYET);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listDuyet.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listDuyet;
    }

    public List<Miss> listMissLoai() throws SQLException {
        List<Miss> listLoai = new ArrayList<>();
        connection();
        try {
            PreparedStatement statement = connec.prepareStatement(LIST_LOAI);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listLoai.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listLoai;
    }

    public List<Miss> listMissChoDuyet() throws SQLException {
        List<Miss> listLoai = new ArrayList<>();
        connection();
        try {
            PreparedStatement statement = connec.prepareStatement(LIST_CHO_DUYET);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idMiss");
                String nameMiss = resultSet.getString("nameMiss");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String passport = resultSet.getString("passport");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String email = resultSet.getString("email");
                String numberPhone = resultSet.getString("numberPhone");
                int idProvince = resultSet.getInt("idProvince");
                String nameProvince = resultSet.getString("province");
                Province province = new Province(idProvince, nameProvince);
                int idNation = resultSet.getInt("idNation");
                String nameNation = resultSet.getString("nation");
                Nation nation = new Nation(idNation, nameNation);
                int idEducation = resultSet.getInt("idEducation");
                String nameEducation = resultSet.getString("education");
                Education education = new Education(idEducation, nameEducation);
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String isDelete = resultSet.getString("isDelete");
                Miss miss = new Miss(id, nameMiss, dateOfBirth, passport, address, job, email, numberPhone, idProvince, idNation, idEducation, image, status, province, nation, education, isDelete);
                listLoai.add(miss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listLoai;
    }


}
