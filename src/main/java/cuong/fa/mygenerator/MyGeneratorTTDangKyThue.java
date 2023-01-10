package cuong.fa.mygenerator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGeneratorTTDangKyThue implements IdentifierGenerator {
	  private String prefix = "DK";
	  @Override
	  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
	    String query = "SELECT e.maDK FROM TTDangKyThue e";
	    Stream<String> ids = session.createQuery(query, String.class).stream();
	    Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
	    return prefix + (String.format("%03d", max + 1));
	  }

}
