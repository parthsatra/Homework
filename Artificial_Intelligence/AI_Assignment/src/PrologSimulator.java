import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrologSimulator {
	
	private static List<Edge> graph = new ArrayList<Edge>();
	private static final String VALUE = "value";
	private static final String EDGE = "edge";

	public static void main(String[] args) {
		PrologSimulator pl = new PrologSimulator();
		pl.initialize();
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			System.out.println("Enter a Query");
			String query = sc.nextLine();
			while(!"exit".equals(query)) {
				if(query != null && !"".equals(query.trim())) {
					int startIndex = query.indexOf("(");
					int endIndex = query.indexOf(")");
					String parameters = query.substring(startIndex+1, endIndex);
					if(parameters != null) {
						String[] arguments = parameters.split(",");
						String node = arguments[0].trim();
						String slot = arguments[1].trim();
						String value = arguments[2].trim();
						if(isVariableSame(node, slot, value)) {
							System.out.println(false);
							return;
						}
						if(arguments.length == 3) {
							List<Edge> valid = null;
							if(query.startsWith(VALUE)) {
								valid = pl.evaluateValue(node, slot, value);
							} else if(query.startsWith(EDGE)) {
								valid = pl.evaluateEdge(node, slot, value);
							}
							if(valid != null && !valid.isEmpty()) {
								if(!isVariable(node) && !isVariable(slot) && !isVariable(value)) {
									System.out.println(true);
								}
								else {
									for (Edge edge : valid) {
										if(isVariable(node)) {
											System.out.println(node + " : " + edge.getSrc());
										}
										if(isVariable(slot)) {
											System.out.println(slot + " : " + edge.getSlot());
										}
										if(isVariable(value)) {
											System.out.println(value + " : " + edge.getTarget());
										}
										System.out.println();
									}
									System.out.println(false);
								}
							} else {
								System.out.println(false);
							}
						}
					}
				}
				System.out.println("Enter new query to continue or type exit to stop");
				query = sc.nextLine();
			}
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}
	
	private List<Edge> evaluateEdge(String node, String slot, String value) {
		List<Edge> answer = new LinkedList<Edge>();
		
		if(isVariable(node)) {
			for (Node x : Node.values()) {
				if(isVariable(slot)) {
					for (Slot s : Slot.values()) {
						if(isVariable(value)) {
							for (Node y : Node.values()) {
								Edge tempEdge = getEdge(x.toString(), s.toString(), y.toString());
								if(isEdgeExists(tempEdge)) {
									answer.add(tempEdge);
								}
							}
						} else {
							Edge tempEdge = getEdge(x.toString(), s.toString(), value);
							if(isEdgeExists(tempEdge)) {
								answer.add(tempEdge);
							}
						}
					}
				} else {
					if(isVariable(value)) {
						for (Node y : Node.values()) {
							Edge tempEdge = getEdge(x.toString(), slot, y.toString());
							if(isEdgeExists(tempEdge)) {
								answer.add(tempEdge);
							}
						}
					} else {
						Edge tempEdge = getEdge(x.toString(), slot, value);
						if(isEdgeExists(tempEdge)) {
							answer.add(tempEdge);
						}
					}
				}
			}
		} else {
			if(isVariable(slot)) {
				for (Slot s : Slot.values()) {
					if(isVariable(value)) {
						for (Node y : Node.values()) {
							Edge tempEdge = getEdge(node, s.toString(), y.toString());
							if(isEdgeExists(tempEdge)) {
								answer.add(tempEdge);
							}
						}
					} else {
						Edge tempEdge = getEdge(node, s.toString(), value);
						if(isEdgeExists(tempEdge)) {
							answer.add(tempEdge);
						}
					}
				}
			} else {
				if(isVariable(value)) {
					for (Node y : Node.values()) {
						Edge tempEdge = getEdge(node, slot, y.toString());
						if(isEdgeExists(tempEdge)) {
							answer.add(tempEdge);
						}
					}
				} else {
					Edge tempEdge = getEdge(node, slot, value);
					if(isEdgeExists(tempEdge)) {
						answer.add(tempEdge);
					}
				}
			}
		}
		return answer;
	}

	private static boolean isVariableSame(String node, String slot,
			String value) {
		if(node.equals(slot) || node.equals(value) || value.equals(slot)) {
			return true;
		}
		return false;
	}

	private List<Edge> evaluateValue(String node, String slot, String value) {
		List<Edge> answer = new LinkedList<Edge>();
		
		if(isVariable(node)) {
			for (Node x : Node.values()) {
				if(isVariable(slot)) {
					for (Slot s : Slot.values()) {
						if(isVariable(value)) {
							for (Node y : Node.values()) {
								List<Edge> temp = processValue(x.toString(), s.toString(), y.toString());
								if(temp != null && !temp.isEmpty()) {
									answer.add(getEdge(x.toString(), s.toString(), y.toString()));
								}
							}
						} else {
							List<Edge> temp = processValue(x.toString(), s.toString(), value);
							if(temp != null && !temp.isEmpty()) {
								answer.add(getEdge(x.toString(), s.toString(), value));
							}
						}
					}
				} else {
					if(isVariable(value)) {
						for (Node y : Node.values()) {
							List<Edge> temp = processValue(x.toString(), slot, y.toString());
							if(temp != null && !temp.isEmpty()) {
								answer.add(getEdge(x.toString(), slot, y.toString()));
							}
						}
					} else {
						List<Edge> temp = processValue(x.toString(), slot, value);
						if(temp != null && !temp.isEmpty()) {
							answer.add(getEdge(x.toString(), slot, value));
						}
					}
				}
			}
		} else {
			if(isVariable(slot)) {
				for (Slot s : Slot.values()) {
					if(isVariable(value)) {
						for (Node y : Node.values()) {
							List<Edge> temp = processValue(node, s.toString(), y.toString());
							if(temp != null && !temp.isEmpty()) {
								answer.add(getEdge(node, s.toString(), y.toString()));
							}
						}
					} else {
						List<Edge> temp = processValue(node, s.toString(), value);
						if(temp != null && !temp.isEmpty()) {
							answer.add(getEdge(node, s.toString(), value));
						}
					}
				}
			} else {
				if(isVariable(value)) {
					for (Node y : Node.values()) {
						List<Edge> temp = processValue(node, slot, y.toString());
						if(temp != null && !temp.isEmpty()) {
							answer.add(getEdge(node, slot, y.toString()));
						}
					}
				} else {
					List<Edge> temp = processValue(node, slot, value);
					if(temp != null && !temp.isEmpty()) {
						answer.add(getEdge(node, slot, value));
					}
				}
			}
		}
		return answer;
	}
	
	private List<Edge> processValue(String node, String slot, String value) {
		List<Edge> answer = new LinkedList<Edge>();
		Edge newEdge = getEdge(node, slot, value);
		if(newEdge != null && isEdgeExists(newEdge)) {
			answer.add(newEdge);
			return answer;
		}
		
		for (Node x : Node.values()) {
			Edge tempEdge = getEdge(node, Slot.isa.toString(), x.toString());
			if(isEdgeExists(tempEdge)) {
				List<Edge> temp = processValue(x.toString(), slot, value);
				if(temp != null && !temp.isEmpty()) {
					answer.add(newEdge);
					return answer;
				}
			}
		}
		
		for (Node x : Node.values()) {
			Edge tempEdge = getEdge(node, Slot.ako.toString(), x.toString());
			if(isEdgeExists(tempEdge)) {
				List<Edge> temp = processValue(x.toString(), slot, value);
				if(temp != null && !temp.isEmpty()) {
					answer.add(newEdge);
					return answer;
				}
			}
		}
		
		if(Slot.shouldAvoid.toString().equals(slot)) {
			for (Node x : Node.values()) {
				List<Edge> temp = processValue(value, Slot.contains.toString(), x.toString());
				if(temp != null && !temp.isEmpty()) {
					List<Edge> temp2 = processValue(node, Slot.shouldAvoid.toString(), x.toString());
					if(temp2 != null && !temp2.isEmpty()) {
						answer.add(newEdge);
						return answer;
					}
				}
			}
		}
		return answer;
	}
	
	private boolean isEdgeExists(Edge edge) {
		if(graph.contains(edge)) {
			return true;
		}
		return false;
	}
	
	private Edge getEdge(String src, String edge, String target) {
		Node node2 = null;
		Node node1 = null;
		for (Node node : Node.values()) {
			if(node.toString().equals(src)) {
				node1 = node;
			} if(node.toString().equals(target)) {
				node2 = node;
			}
		}
		
		Slot slot = null;
		for (Slot slot1 : Slot.values()) {
			if(slot1.toString().equals(edge)) {
				slot = slot1;
				break;
			}
		}
		
		Edge newEdge = new Edge(node1, slot, node2);
		return newEdge;
	}
	
	private static boolean isVariable(String var) {
		String firstLetter = var.charAt(0) + "";
		if(firstLetter.equals(firstLetter.toUpperCase())) {
			return true;
		}
		return false;
	}

	private void initialize() {
		graph.add(new Edge(Node.david, Slot.isa, Node.diabetics));
		graph.add(new Edge(Node.diabetics, Slot.shouldAvoid, Node.sugar));
		graph.add(new Edge(Node.candy, Slot.contains, Node.sugar));
		graph.add(new Edge(Node.snickers, Slot.ako, Node.candy));
	}
	
	class Edge {
		private Node Src;
		private Slot slot;
		private Node target;
		
		public Edge(Node src, Slot slot, Node target) {
			super();
			Src = src;
			this.slot = slot;
			this.target = target;
		}

		public Node getSrc() {
			return Src;
		}

		public void setSrc(Node src) {
			Src = src;
		}

		public Slot getSlot() {
			return slot;
		}

		public void setSlot(Slot slot) {
			this.slot = slot;
		}

		public Node getTarget() {
			return target;
		}

		public void setTarget(Node target) {
			this.target = target;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((Src == null) ? 0 : Src.hashCode());
			result = prime * result + ((slot == null) ? 0 : slot.hashCode());
			result = prime * result
					+ ((target == null) ? 0 : target.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Src != other.Src)
				return false;
			if (slot != other.slot)
				return false;
			if (target != other.target)
				return false;
			return true;
		}

		private PrologSimulator getOuterType() {
			return PrologSimulator.this;
		}
	}
	
	public enum Node {
		david, diabetics, sugar, candy, snickers,
	};
	
	public enum Slot {
		shouldAvoid, contains, isa, ako,
	};
}
