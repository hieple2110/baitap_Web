package com.hiep.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BaseService<G> {

    public ArrayList<String> listResult(G g);

    public List<G> getAll() throws SQLException;

    public ArrayList<String> insert(G g) throws SQLException;

    public ArrayList<String> update(int id, G g) throws SQLException;

    public String delete(int id) throws SQLException;

    public G findById(int id) throws SQLException;

    public boolean checkDuplicate(G g) throws SQLException;
}
