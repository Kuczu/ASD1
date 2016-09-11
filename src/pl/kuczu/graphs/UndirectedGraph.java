package pl.kuczu.graphs;

import pl.kuczu.abstractDataType.linked.LinkedQueue;
import pl.kuczu.abstractDataType.linked.LinkedStack;

import java.util.Queue;

public class UndirectedGraph {
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int vertexNumber;

    public UndirectedGraph(int matrixSize){
        this.adjacencyMatrix = new int[matrixSize][matrixSize];
        this.vertexList = new Vertex[matrixSize];
        this.vertexNumber = 0;

        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[vertexNumber] = new Vertex(label);
        vertexNumber++;
    }

    public void addEdge(int start, int end){
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void displayVertex(int vertexNumb){
        System.out.print(vertexList[vertexNumb].label);
    }

    public void bfs(int startVertex){
        vertexList[startVertex].wasVisited = true;
        displayVertex(startVertex);

        LinkedQueue queue = new LinkedQueue();

        queue.enQueue(startVertex);

        while(!queue.isEmpty()){
            int firstVertex = queue.deQueue();
            int vertex = getAdjUnvisitedVertex(firstVertex);

            while(vertex != -1){
                vertexList[vertex].wasVisited = true;
                displayVertex(vertex);
                queue.enQueue(vertex);

                vertex = getAdjUnvisitedVertex(firstVertex);
            }
        }
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);

        LinkedStack stack = new LinkedStack();
        stack.push(0);

        while(!stack.isEmpty()){
            int vertex = getAdjUnvisitedVertex(stack.top());

            if(vertex == -1){
                stack.pop();
            }
            else{
                vertexList[vertex].wasVisited = true;
                displayVertex(vertex);
                stack.push(vertex);
            }
        }
    }

    public void mst(){
        vertexList[0].wasVisited = true;

        LinkedStack stack = new LinkedStack();
        stack.push(0);

        while(!stack.isEmpty()){
            int vertex1 = stack.top();
            int vertex2 = getAdjUnvisitedVertex(vertex1);

            if(vertex2 == -1){
                stack.pop();
            }
            else{
                vertexList[vertex2].wasVisited = true;
                stack.push(vertex2);

                displayVertex(vertex1);
                displayVertex(vertex2);
                System.out.print(", ");
            }
        }
    }

    public int getAdjUnvisitedVertex(int vertex){
        for(int i = 0; i < vertexNumber; i++){
            if(adjacencyMatrix[vertex][i] == 1 && !vertexList[i].wasVisited){
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        UndirectedGraph graph = new UndirectedGraph(5);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.print("Odwiedzone wierzchołki: ");
        //graph.bfs(0);
        //graph.dfs();
        graph.mst();
    }
}
