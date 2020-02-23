package DAO;

import static DAO.Service.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Logic.Usuario;
import Parameters.CRUD_Usuario;
import Parameters.Menssage_Error;
import java.util.List;
import oracle.jdbc.OracleTypes;
import static Logic.Utils.createPersona;
import static Logic.Utils.loadPersona;

public class DAO_Usuario extends Service {

    private static final DAO_Usuario dao = new DAO_Usuario();

    public DAO_Usuario() {
    }

    public static DAO_Usuario getDAO() {
        return dao;
    }

    public void insert(Usuario object) throws Exception {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.INSERT.getValue());
                pstmt.setString(1, object.getUsuario());
                pstmt.setString(2, object.getContrasenna());
                pstmt.setString(3, object.getPersona().type.getValue());
                pstmt.setInt(4, object.getPersona().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_INSERTED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public void update(Usuario object) throws Exception {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.UPDATE.getValue());
                pstmt.setInt(1, object.getId());
                pstmt.setString(2, object.getUsuario());
                pstmt.setString(3, object.getContrasenna());
                pstmt.setString(4, object.getPersona().type.getValue());
                pstmt.setInt(5, object.getPersona().getId());
                if (pstmt.execute()) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_UPDATED.getValue());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
    }

    public Usuario query(Usuario p_object) throws Exception {
        Usuario object = new Usuario();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.QUERY.getValue());
                pstmt.setInt(2, p_object.getId());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    object.setId(rs.getInt(1));
                    object.setUsuario(rs.getString(2));
                    object.setContrasenna(rs.getString(3));
                    object.setPersona(createPersona(
                            rs.getString(4),
                            rs.getInt(5)
                    )
                    );
                }
                if (object.getId() == -1) {
                    throw new RuntimeException(Menssage_Error.OBJECT_NOT_FOUND.getValue());
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        object.setPersona(
                loadPersona(object.getPersona())
        );
        return object;
    }

    public List<Usuario> list() throws Exception {
        List<Usuario> list = new ArrayList();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.LIST.getValue());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    Usuario object = new Usuario();
                    object.setId(rs.getInt(1));
                    object.setUsuario(rs.getString(2));
                    object.setContrasenna(rs.getString(3));
                    object.setPersona(createPersona(
                            rs.getString(4),
                            rs.getInt(5)
                    )
                    );
                    list.add(object);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        for (Usuario object : list) {
            object.setPersona(
                    loadPersona(object.getPersona())
            );
        }
        return list;
    }

    public void delete(Usuario p_object) throws Exception {
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.DELETE.getValue());
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

    public Usuario login(Usuario p_object) throws Exception {
        Usuario object = new Usuario();
        general_method((CallableStatement pstmt) -> {
            try {
                pstmt = connection.prepareCall(CRUD_Usuario.LOGIN.getValue());
                pstmt.setString(2, p_object.getUsuario());
                pstmt.setString(3, p_object.getContrasenna());
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                while (rs.next()) {
                    object.setId(rs.getInt(1));
                    object.setUsuario(rs.getString(2));
                    object.setContrasenna(rs.getString(3));
                    object.setPersona(createPersona(
                            rs.getString(4),
                            rs.getInt(5)
                    )
                    );
                }
                if (object.getId() == -1) {
                    throw new RuntimeException(Menssage_Error.LOGIN_NOT_ESTABLISHED.getValue());
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            return pstmt;
        });
        object.setPersona(
                loadPersona(object.getPersona())
        );
        return object;
    }
}
