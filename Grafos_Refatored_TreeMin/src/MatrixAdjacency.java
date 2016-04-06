
public class MatrixAdjacency extends ComputationalRepresentation{
	private int matrix[][];
	private int weight[][];
	
	public MatrixAdjacency(int sizeVertex){
		super(sizeVertex);
		matrix = new int[sizeVertex][sizeVertex];
		weight = new int[sizeVertex][sizeVertex];
	}
	
	public void addEdge(int u, int v, int w){
		matrix[u][v] = 1;
		matrix[v][u] = 1;
		weight[u][v] = w;
		weight[v][u] = w;
	}
	
	public boolean verifyAdjacency(int u, int v){
		return matrix[u][v] == 1;
	}
	
	public void show(){
		for(int i=0; i<this.sizeVertex; i++){
			for(int j=0; j<this.sizeVertex; j++){
				System.out.print(matrix[i][j]+ "(P:"+weight[i][j]+") ");
			}
			System.out.println();
		}
	}
	
	public int getWeight(int value){
		for(int i=0; i<this.sizeVertex; i++){
			for(int j=0; j<this.sizeVertex; j++){
				if(matrix[i][j] == value){
					return weight[i][j];
				}
			}
		}
		return 0;
	}
}
