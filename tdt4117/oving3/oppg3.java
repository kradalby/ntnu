BooleanQuery query = new BooleanQuery();
StringTokenizer st = new StringTokenizer(line);
	while (st.hasMoreTokens()) {
		TermQuery tq =  new TermQuery(new Term("contents", st.nextToken()));
		query.add(tq, BooleanClause.Occur.SHOULD);
	}