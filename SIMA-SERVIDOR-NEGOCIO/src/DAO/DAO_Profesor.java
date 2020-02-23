package DAO;

import static DAO.Service.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Logic.Profesor;
import Parameters.CRUD_Profesor;
import Parameters.Menssage_Error;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAO_Profesor extends Service {

    private static final DAO_Profesor dao = new DAO_Profesor();

    public DAO_Profesor() {
    }

    public static DAO_Profesor getDAO() {
        return dao;
    }

    public void insert(Profesor object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Profesor.INSERT.getValue());
                pstmt.setString(1, object.getCedula());
                pstmt.setString(2, object.getNombre());
                pstmt.setString(3, object.getApe_1());
                pstmt.setString(4, object.getApe_2());
                pstmt.setString(5, object.getTel());
                pstmt.setString(6, object.getCorreo());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_INSERTED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public void update(Profesor object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Profesor.UPDATE.getValue());
                pstmt.setInt(1, object.getId());
                pstmt.setString(2, object.getCedula());
                pstmt.setString(3, object.getNombre());
                pstmt.setString(4, object.getApe_1());
                pstmt.setString(5, object.getApe_2());
                pstmt.setString(6, object.getTel());
                pstmt.setString(7, object.getCorreo());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_UPDATED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public Profesor query(Profesor p_object) {
        Profesor object = new Profesor();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Profesor.QUERY.getValue());
                pstmt.setInt(2, p_object.getId());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    object.setId(rs.getInt(1));
                    object.setCedula(rs.getString(2));
                    object.setNombre(rs.getString(3));
                    object.setApe_1(rs.getString(4));
                    object.setApe_2(rs.getString(5));
                    object.setTel(rs.getString(6));
                    object.setCorreo(rs.getString(7));
                }
                if(object.getId() == -1){
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_FOUND.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        return object;
    }

    public List<Profesor> list() {
        List<Profesor> list = new ArrayList();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Profesor.LIST.getValue());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    Profesor object = new Profesor();
                    object.setId(rs.getInt(1));
                    object.setCedula(rs.getString(2));
                    object.setNombre(rs.getString(3));
                    object.setApe_1(rs.getString(4));
                    object.setApe_2(rs.getString(5));
                    object.setTel(rs.getString(6));
                    object.setCorreo(rs.getString(7));
                    list.add(object);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        return list;
    }

    public void delete(Profesor p_object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Profesor.DELETE.getValue());
                pstmt.setInt(1, p_object.getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_DELETED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }
}
