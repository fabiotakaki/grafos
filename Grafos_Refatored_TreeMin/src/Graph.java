
public class Graph {
	private int sizeVertex;
	private ComputationalRepresentation rep;
	public Graph(int sizeVertex, ComputationalRepresentation rep){
		this.sizeVertex = sizeVertex;
		this.rep = rep;
	}
	
	public void addEdge(int u, int v, int w){
		rep.addEdge(u, v, w);
	}
	
	public boolean verifyAdjacency(int u, int v){
		return rep.verifyAdjacency(u, v);
	}
	
	public void show(){
		System.out.println("Número de Vértices: "+this.sizeVertex);
		rep.show();
	}
	
	public int getSizeVertex(){
		return sizeVertex;
	}
	
	public int getWeight(int value){
		return rep.getWeight(value);
	}

}
