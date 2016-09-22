import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static BufferedReader readFile;
	private static Scanner read;

	public static void main(String[] args) {
		System.out.println("Sisteminha de Grafos");
		read = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo.");
		String name = read.nextLine();
		try{
			// realizo a leitura do arquivo
			FileReader file = new FileReader(name);
			readFile = new BufferedReader(file);
			String line = readFile.readLine();
			int sizeVertex = Integer.parseInt(line);
			
			// Crio o Grafo
			Graph g = new Graph(sizeVertex, new ListAdjacency(sizeVertex));
			
			// caminho mais uma vez para começar a leitura das arestas
			line = readFile.readLine();
			while(line != null){
				String aux = line;
				String[] split = aux.split(" ");
				g.addEdge( Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]) );

				line = readFile.readLine();
			}
			
			g.show();
			
			System.out.println("BUSCA EM PROFUNDIDADE:");
			DepthSearch x = new DepthSearch(g);
			x.process(0);
			x.show();
			
			System.out.println();
		
			System.out.println("BUSCA EM LARGURA:");
			WidthSearch h = new WidthSearch(g);
			h.process(0);
			h.show();
			
			
//			Prim p = new Prim(g);
//			Graph prim = p.process();
//			prim.show();
//			
//			System.out.println("KRUSKAL !");
//			Kruskal k = new Kruskal(g);
//			k.process();
//			
//			BellmanFord bf = new BellmanFord(g);
//			bf.process();
//			
//			Dijkstra dij = new Dijkstra(g);
//			dij.process();
			
			CheckPath cp = new CheckPath(g);
			cp.processWidthSerch(0, 1);
			cp.processWidthSerch(0, 2);
			cp.processWidthSerch(0, 3);
			cp.processWidthSerch(2, 1);
				
			cp.processDepthSearch(0, 1);

		}catch(IOException e){
			System.err.printf("Erro na abertura de arquivo %s \n", e.getMessage());
		}
	}

}
