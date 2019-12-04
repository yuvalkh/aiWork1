import java.util.*;

public class UniformCostSearch   extends ASearch
{
	PriorityQueue<ASearchNode> openList;
	Map<ASearchNode,ASearchNode> openSet;
	HashSet<ASearchNode> closedSet;

	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot(TopSpinPuzzleState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		openSet = new HashMap<>();
		closedSet = new HashSet<>();
		openList = new PriorityQueue<>((o1, o2) -> (int)(o1.G()-o2.G()));
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if(openSet.containsKey(node)){
			return openList.peek();
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if (openSet.containsKey(node)) {
			return openSet.get(node).equals(node);
		}
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		return closedSet.contains(node);
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		openList.add(node);
		openSet.put(node,node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		closedSet.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		ASearchNode bestNode = openList.poll();
		openSet.remove(bestNode);
		return bestNode;
	}

}
