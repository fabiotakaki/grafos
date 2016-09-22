public class Dijkstra {
	private Graph g;
	private int d[];
	private int pi[];
	// Q->nós com distancia provisória
	private boolean Q[];
	// S->nós com distancia definitiva
	private boolean S[];
	
	public Dijkstra(Graph g){
		this.g = g;
		this.d = new int[g.getSizeVertex()];
		this.pi = new int[g.getSizeVertex()];
		this.Q = new boolean[g.getSizeVertex()];
		this.S = new boolean[g.getSizeVertex()];
	}
	
	protected void relax(int u, int v){
		if(d[v] > (d[u] + g.getWeight(u, v))){
			d[v] = d[u] + g.getWeight(u, v);
			pi[v] = u;
		}
	}
	
	protected int extractMin(){
		int aux = Integer.MAX_VALUE;
		int x = 4;
		for(int i=0; i<g.getSizeVertex(); i++){
			if(d[i] < aux && Q[i] == false){
				aux = d[i];
				x = i;
			}
		}
		Q[x] = true;
		return x;
	}
	
	protected boolean emptyQ(){
		for(int i=0; i<g.getSizeVertex(); i++){
			if(Q[i] == false) return false;
		}
		return true;
	}
	
	public void process(){
		int s = 0;
		//inicializa
		for(int i=0; i<g.getSizeVertex(); i++){
			d[i] = Integer.MAX_VALUE;
			pi[i] = -1;
			Q[i] = false;
			S[i] = true;
		}
		d[s] = 0;
		
		while(emptyQ() == false){
			int u = extractMin();
			// S <- S U {u}
			S[u] = false;
			for(int v=0; v<g.getSizeVertex(); v++){
				if(g.verifyAdjacency(v, u)){
					relax(u, v);
				}
			}
		}
		
		System.out.println("DIJKSTRA");
		for(int i=0; i<g.getSizeVertex(); i++){
			System.out.println("D["+i+"]:"+d[i]);
		}
		for(int i=0; i<g.getSizeVertex(); i++){
			System.out.println("PI["+i+"]:"+pi[i]);
		}
		
	}
	
}
