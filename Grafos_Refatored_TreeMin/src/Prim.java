
public class Prim {
	private int Q[]; // vértices que ainda não fazem parte de X
	private int key[]; // peso da aresta mais leve do vértice key[u]
	private int X[]; // resultado da arvore minima
	private int pi[]; // vértice pai do vértice pi[u]
	private Graph g;
	
	public Prim(Graph g){
		this.g  = g;
		Q 		= new int[g.getSizeVertex()];
		key 	= new int[g.getSizeVertex()];
		X 		= new int[g.getSizeVertex()];
		pi 		= new int[g.getSizeVertex()];
		for(int i = 0; i<g.getSizeVertex(); i++){
			Q[i] = 0;
		}
	}
	
	protected boolean emptyQ(){
		for(int i=0; i<g.getSizeVertex(); i++){
			if(Q[i] == 1){
				return true;
			}
		}
		return false;
	}
	
	protected int extractMin(){
		int aux = Integer.MAX_VALUE;
		for(int i=0; i<g.getSizeVertex(); i++){
			if(g.getWeight(i) < aux && Q[i] != 0){
				aux = i;
			}
		}
		return aux;
	}
	
	public void process(){
		int r = 0;
		for(int i=0; i<g.getSizeVertex(); i++){
			key[i] = Integer.MAX_VALUE;
			Q[i] = 1;
		}
		key[r] = 0;
		
		while(emptyQ()){
			int u = extractMin();
		}
	}
	
}
