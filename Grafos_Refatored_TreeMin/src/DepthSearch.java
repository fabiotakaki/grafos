
public class DepthSearch {
	private Graph g;
	private String[] colors;
	private int[] starts;
	private int[] ends;
	private int time;
	
	private int goodPath[];
	private boolean verify;
	
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
		
		this.goodPath = new int[g.getSizeVertex()];
		this.verify = true;
	}
	
	public void process(int num){
		
		for(int i=0; i< g.getSizeVertex(); i++){
			this.colors[i] = "w";
			this.goodPath[i] = -1;
		}
		
		this.time = 0;
		
		if(colors[num].equals("w")){
			visit(num); // visito o vértice
		}
		verify = false;
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
			if(g.verifyAdjacency(i, j)){
				if(colors[j] == "w"){
					visit(j);
					if(verify) goodPath[j] = i;
				}
			}
		}
		colors[i] = "b";
		this.time++;
		ends[i] = this.time;
		
	}
	
	public int[] getGoodPath(){
		return goodPath;
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
