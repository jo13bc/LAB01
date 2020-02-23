package DAO;

import Logic.Carrera;
import Logic.Ciclo;
import Logic.Curso;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Parameters.CRUD_Curso;
import Parameters.Menssage_Error;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAO_Curso extends Service {

    private static final DAO_Curso dao = new DAO_Curso();

    public DAO_Curso() {
    }

    public static DAO_Curso getDAO() {
        return dao;
    }

    public void insert(Curso object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Curso.INSERT.getValue());
                pstmt.setString(1, object.getCodigo());
                pstmt.setString(2, object.getNombre());
                pstmt.setInt(3, object.getCreditos());
                pstmt.setInt(4, object.getHora_semana());
                pstmt.setInt(5, object.getAnno());
                pstmt.setInt(6, object.getCiclo().getId());
                pstmt.setInt(7, object.getCarrera().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_INSERTED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public void update(Curso object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Curso.UPDATE.getValue());
                pstmt.setInt(1, object.getId());
                pstmt.setString(2, object.getCodigo());
                pstmt.setString(3, object.getNombre());
                pstmt.setInt(4, object.getCreditos());
                pstmt.setInt(5, object.getHora_semana());
                pstmt.setInt(6, object.getAnno());
                pstmt.setInt(7, object.getCiclo().getId());
                pstmt.setInt(8, object.getCarrera().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_UPDATED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public Curso query(Curso p_object) {
        Curso object = new Curso();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Curso.QUERY.getValue());
                pstmt.setInt(2, p_object.getId());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    object.setId(rs.getInt(1));
                    object.setCodigo(rs.getString(2));
                    object.setNombre(rs.getString(3));
                    object.setCreditos(rs.getInt(4));
                    object.setHora_semana(rs.getInt(5));
                    object.setAnno(rs.getInt(6));
                    object.setCiclo(
                            new Ciclo(rs.getInt(7))
                    );
                    object.setCarrera(
                            new Carrera(rs.getInt(8))
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

    public List<Curso> list() {
        List<Curso> list = new ArrayList();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Curso.LIST.getValue());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    Curso object = new Curso();
                    object.setId(rs.getInt(1));
                    object.setCodigo(rs.getString(2));
                    object.setNombre(rs.getString(3));
                    object.setCreditos(rs.getInt(4));
                    object.setHora_semana(rs.getInt(5));
                    object.setAnno(rs.getInt(6));
                    object.setCiclo(
                            new Ciclo(rs.getInt(7))
                    );
                    object.setCarrera(
                            new Carrera(rs.getInt(8))
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

    public void delete(Curso object) {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Curso.DELETE.getValue());
                pstmt.setInt(1, object.getId());
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
