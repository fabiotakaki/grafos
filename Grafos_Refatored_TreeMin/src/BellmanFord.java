import java.util.ArrayList;

public class BellmanFord {
	private Graph g;
	private int d[];
	private int pi[];
	private ArrayList<Edge> A;
	
	public BellmanFord(Graph g){
		this.g = g;
		this.d = new int[g.getSizeVertex()];
		this.pi = new int[g.getSizeVertex()];
		this.A = new ArrayList<Edge>();
	}
	
	protected void relax(int u, int v){
		if(d[v] > (d[u] + g.getWeight(u, v))){
			d[v] = d[u] + g.getWeight(u, v);
			pi[v] = u;
		}
	}
	
	protected boolean bellman(){
		int s = 0;
		// inicializa !!
		for(int i=0; i<g.getSizeVertex(); i++){
			d[i] = 999999999;
			pi[i] = -1;
		}
		d[s] = 0;
		
		A = g.getEdges();
		
		// Processa o Bellman !!
		for(int i = 0; i<g.getSizeVertex(); i++){
			for(int j=0; j<A.size(); j++){
				relax(A.get(j).getFrom(), A.get(j).getTo());
			}
		}
		
		for(int j=0; j<A.size(); j++){
			if(d[A.get(j).getTo()] > d[A.get(j).getFrom()] + g.getWeight(A.get(j).getFrom(), A.get(j).getTo()))
				return false;
		}
		return true;	
	}
	
	public void process(){
		System.out.println("BELLMAN");
		if(bellman()){
			for(int i=0; i<g.getSizeVertex(); i++){
				System.out.println("D["+i+"]:"+d[i]);
			}
			for(int i=0; i<g.getSizeVertex(); i++){
				System.out.println("PI["+i+"]:"+pi[i]);
			}
		}
	}
}
