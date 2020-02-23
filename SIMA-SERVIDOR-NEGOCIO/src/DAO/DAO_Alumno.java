package DAO;

import static DAO.Service.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Logic.Alumno;
import Logic.Carrera;
import Parameters.CRUD_Alumno;
import Parameters.Menssage_Error;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAO_Alumno extends Service {

    private static final DAO_Alumno dao = new DAO_Alumno();

    public DAO_Alumno() {
    }

    public static DAO_Alumno getDAO() {
        return dao;
    }
    
    public void insert(Alumno object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Alumno.INSERT.getValue());
                pstmt.setString(1, object.getCedula());
                pstmt.setString(2, object.getNombre());
                pstmt.setString(3, object.getApe_1());
                pstmt.setString(4, object.getApe_2());
                pstmt.setString(5, object.getTel());
                pstmt.setString(6, object.getCorreo());
                pstmt.setDate(7, object.getFecha_nacimiento());
                pstmt.setInt(8, object.getCarrera().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_INSERTED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public void update(Alumno object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Alumno.UPDATE.getValue());
                pstmt.setInt(1, object.getId());
                pstmt.setString(2, object.getCedula());
                pstmt.setString(3, object.getNombre());
                pstmt.setString(4, object.getApe_1());
                pstmt.setString(5, object.getApe_2());
                pstmt.setString(6, object.getTel());
                pstmt.setString(7, object.getCorreo());
                pstmt.setDate(8, object.getFecha_nacimiento());
                pstmt.setInt(9, object.getCarrera().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_UPDATED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public Alumno query(Alumno p_object) {
        Alumno object = new Alumno();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Alumno.QUERY.getValue());
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
                    object.setFecha_nacimiento(rs.getDate(8));
                    object.setCarrera(
                            new Carrera(rs.getInt(9))
                    );
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

    public List<Alumno> list() {
        List<Alumno> list = new ArrayList();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Alumno.LIST.getValue());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    Alumno object = new Alumno();
                    object.setId(rs.getInt(1));
                    object.setCedula(rs.getString(2));
                    object.setNombre(rs.getString(3));
                    object.setApe_1(rs.getString(4));
                    object.setApe_2(rs.getString(5));
                    object.setTel(rs.getString(6));
                    object.setCorreo(rs.getString(7));
                    object.setFecha_nacimiento(rs.getDate(8));
                    object.setCarrera(
                            new Carrera(rs.getInt(9))
                    );
                    list.add(object);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        return list;
    }

    public void delete(Alumno p_object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Alumno.DELETE.getValue());
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
