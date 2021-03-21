import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class RDFTest {

    public static void main(String[] args) {

    }

    public void firstTest() {
        String URI = "http://somewhere/Jon";
        String fullName = "Jon Smith";
        Model model = ModelFactory.createDefaultModel();
        Resource jon = model.createResource(URI);
        jon.addProperty(VCARD.FN, fullName);
        model.write(System.out);
    }

    public void readTest() {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // use the RDFDataMgr to find the input file
        InputStream in = RDFDataMgr.open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

// read the RDF/XML file
        model.read(in, null);

// write it to standard out
        model.write(System.out);
    }
}
