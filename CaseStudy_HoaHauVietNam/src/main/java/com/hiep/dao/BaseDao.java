package com.hiep.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<G> {

    public List<G> getAll() throws SQLException;

    public void insert(G g) throws SQLException;

    public boolean update(int id, G g) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public G findById(int id) throws SQLException;
}
