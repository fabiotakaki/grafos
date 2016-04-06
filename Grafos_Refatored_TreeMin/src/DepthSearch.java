
public class DepthSearch {
	private Graph g;
	private String[] colors;
	private int[] starts;
	private int[] ends;
	private int time;
	
	/*
	 * colors:
	 *		w: white
	 * 		g: gray
	 *		b: black
	 */
	
	public DepthSearch(Graph g){
		this.g 		= g;
		this.time	= 0;
		this.colors = new String[g.getSizeVertex()];
		this.starts = new int[g.getSizeVertex()];
		this.ends 	= new int[g.getSizeVertex()];
	}
	
	public void process(){
		
		for(int i=0; i< g.getSizeVertex(); i++){
			this.colors[i] = "w";
		}
		
		this.time = 0;
		
		for(int i=0; i< g.getSizeVertex(); i++){
			if(colors[i].equals("w"))
				visit(i); // visito o vértice
		}
	}
	
	protected void visit(int i){
		this.colors[i] = "g";
		this.time++;
		this.starts[i] = time;
		
		for(int j=0; j < g.getSizeVertex(); j++){
			if(g.verifyAdjacency(j, i)){
				if(colors[j] == "w")
					visit(j);
			}
		}
		colors[i] = "b";
		this.time++;
		ends[i] = this.time;
		
	}
	
	public void show(){
		for(int i=0; i< g.getSizeVertex(); i++){
			System.out.println();
			System.out.println("Vértice "+i);
			System.out.println("   Tempo de chegada:" + starts[i]);
			System.out.println("   Tempo de finalização:" + ends[i]);
			System.out.println("   Cor:" + colors[i]);
			System.out.println();
		}
	}
}
