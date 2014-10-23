package com.jung.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class BasicGraphCreation {
	
	class Vertex{
		double X;
		double Y;
		public Vertex(double X, double Y){
			this.X = X;
			this.Y = Y;
		}
		
	}
	
	class Edge {
		 private Vertex fromVertex; // should be private 
		 private Vertex toVertex; // should be private for good practice
		 int id;
		 
		 public Edge(Vertex v1, Vertex v2) {
			 this.fromVertex = v1;
			 this.toVertex = v2;
		 } 
		 
	
	Graph<Vertex,Edge> graph = new UndirectedSparseGraph<Vertex, Edge>(); 
	
	public void readCSVFile(String csvFile){
		
		int i = 0;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] coordinates = line.split(cvsSplitBy);
				double x1 = Double.parseDouble(coordinates[0]);
				double y1 = Double.parseDouble(coordinates[1]);
				double x2 = Double.parseDouble(coordinates[2]);
				double y2 = Double.parseDouble(coordinates[3]);
				addElementsToGraph(x1,y1,x2,y2);
				i =  i + 2;
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
	  }

	private Graph addElementsToGraph(double x1, double y1, double x2, double y2) {
		Vertex vertex1 = new Vertex(x1, y1);
		Vertex vertex2 = new Vertex(x2, y2);
		Edge edge = new Edge(vertex1, vertex2);
		if(!graph.containsVertex(vertex1)){
			graph.addVertex(vertex1);
		}
		if(!graph.containsVertex(vertex2)){
			graph.addVertex(vertex2);
		}
		if(!graph.containsEdge(arg0))
		return null;
		
	}
	
}
	
