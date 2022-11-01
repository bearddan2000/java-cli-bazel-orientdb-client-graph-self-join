package example.dto;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

public class Doctor {
  final String EDGENAME = "ReferedFrom";
  final String DOCNAME = "Doctor";
  final String PROPNAME = "name";

  OVertex prev = null;
  ODatabaseSession db;

  public Doctor(ODatabaseSession session) {

    db = session;

    OClass doctor = db.getClass(DOCNAME);

    if (doctor == null) {
        doctor = db.createVertexClass(DOCNAME);
    }

    if (doctor.getProperty(PROPNAME) == null) {
        doctor.createProperty(PROPNAME, OType.STRING);
        doctor.createIndex("IDX_" + PROPNAME, OClass.INDEX_TYPE.NOTUNIQUE, PROPNAME);
    }

    if (db.getClass(EDGENAME) == null) {
        db.createEdgeClass(EDGENAME);
    }
  }

  private OVertex setName(String name)
  {
      OVertex result = db.newVertex(DOCNAME);
      result.setProperty(PROPNAME, name);
      result.save();
      return result;
  }

  public void insert(String name)
  {
    OVertex doctor = setName(name);

    if(prev != null)
    {
      OEdge edge = doctor.addEdge(prev, EDGENAME);
      edge.save();
    }
    prev = doctor;
  }

  public void findAll()
  {
      String query = "SELECT * FROM " + DOCNAME;
      OResultSet rs = db.query(query);

      while (rs.hasNext()) {
          OResult item = rs.next();
          System.out.println("[OUTPUT] " + DOCNAME + ": " + item.getProperty(PROPNAME));
      }

      rs.close();
  }
}
