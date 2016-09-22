public class CheckPath {
    private Graph g;
    
    public CheckPath(Graph g) {
        this.g = g;
    }

    public void processWidthSerch(int u, int v){
    	WidthSearch x = new WidthSearch(g);
    	x.process(u);
    	String colors[] = x.getColors();
    	int pi[] = x.getPi();
    	if(colors[u].equals("b") && colors[v].equals("b")){
    		System.out.println("Existe caminho entre "+u+" até "+v);
    		int aux = pi[v];
    		System.out.print(v);
    		while(aux != -1){
    			System.out.print("<-"+aux);
    			aux = pi[aux];
    		}
    		System.out.println();
    	}
    }
    
    public void processDepthSearch(int u, int v){
    	DepthSearch x = new DepthSearch(g);
    	x.process(u);
    	int gp[] = x.getGoodPath();
    	for(int i=0; i<g.getSizeVertex(); i++){
    		System.out.println(gp[i]);
    	}
    }

}