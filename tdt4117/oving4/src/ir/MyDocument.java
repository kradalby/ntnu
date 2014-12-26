package ir;

import java.io.File;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;

public class MyDocument {

	public static Document Document(File f)
			throws java.io.FileNotFoundException {

		// make a new, empty document
		Document doc = new Document();

		// use the news document wrapper
		NewsDocument newsDocument = new NewsDocument(f);

		//TODO create structured lucene document

		//============START OUR CODE=======================//
		// Adding path
		doc.add(new Field("path", f.getAbsolutePath(), Store.YES, Field.Index.ANALYZED));

		// Adding from
		doc.add(new Field("from", newsDocument.getFrom(), Store.YES, Field.Index.NO));

		// Adding subject
		doc.add(new Field("subject", newsDocument.getSubject(), Store.YES, Field.Index.ANALYZED));

		// Adding content
		doc.add(new Field("content", newsDocument.getContent(), Store.YES, Field.Index.ANALYZED));
		//============END OUR CODE=======================//

		// return the document
		return doc;
	}

}
