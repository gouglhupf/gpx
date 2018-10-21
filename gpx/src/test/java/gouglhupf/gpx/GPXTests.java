package gouglhupf.gpx;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GPXTests {

    private final static String gpxSchema = "src/test/resources/gouglhupf/gpx/gpx.xsd";

    @Test
    void writeGPXValid() {
        GPX gpx = GPX.builder().wayPoints(
                WayPoint.builder()
                        .lat(12.2345)
                        .lon(31.1345)
                        .build(),
                WayPoint.builder()
                        .lat(12.32345)
                        .lon(1.1345)
                        .build())
                .build();

        OutputStream stream = new ByteArrayOutputStream();
        GPX.toXML(gpx, stream);
        String xml = stream.toString();

        System.out.println(xml);

        try {
            InputStream gpxSchemaStream = new BufferedInputStream(
                    new FileInputStream(gpxSchema));

            assertTrue(validateAgainstXSD(xml, gpxSchemaStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "src/test/resources/gouglhupf/gpx/Gpx-full-sample.gpx"
    })
    void readGPX(String path) throws FileNotFoundException {
        GPX.fromXML(
                new BufferedInputStream(
                        new FileInputStream(new File(path))));
    }

    private static boolean validateAgainstXSD(String xml, InputStream xsd) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(
                    new StreamSource(new StringReader(xml))
            );
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
