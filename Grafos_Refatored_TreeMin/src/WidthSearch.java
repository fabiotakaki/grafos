
public class WidthSearch {
	private Graph g;
	private String[] colors;
	private int pi[];
	private int distance[];
	private Queue q;
	
	public WidthSearch(Graph g){
		this.g 	 = g;
		colors 	 = new String[g.getSizeVertex()];
		pi 		 = new int[g.getSizeVertex()];
		distance = new int[g.getSizeVertex()];
		q		 = new Queue();
	}
	
	public void process(int n){
		int s = n;
		int w = 0;
		for(int i=1; i<g.getSizeVertex(); i++){
			colors[i] = "w";
			distance[i] = Integer.MAX_VALUE;
			pi[i] = -1;
		}

		colors[s] = "g";
		distance[s] = 0;
		pi[s] = -1;
		q.add(s, w);
		
		while(!q.verifyEmpty()){
			Item u = q.getHead();
			q.remove();
			for(int v=0; v<g.getSizeVertex(); v++){
				if(g.verifyAdjacency(u.getValue(), v)){
					if(colors[v] == "w"){
						colors[v] = "g";
						distance[v] = distance[u.getValue()]+1;
						pi[v] = u.getValue();
						q.add(v, w);
					}
				}
			}
			colors[u.getValue()] = "b";
		}
	}
	
	public int[] getPi(){
		return this.pi;
	}
	
	public String[] getColors(){
		return this.colors;
	}
	
	public void show(){
		for(int i=0; i< g.getSizeVertex(); i++){
			System.out.println();
			System.out.println("Vértice "+i);
			System.out.println("   Distância:" + distance[i]);
			System.out.println("   Cor:" + colors[i]);
			System.out.println();
		}
	}
}
