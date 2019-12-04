import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	Map<ASearchNode,ASearchNode> openSet;
	HashSet<ASearchNode> closedSet;
	LinkedList<ASearchNode> openList;

	@Override
	public String getSolverName()
	{
		return "BFS";
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
        openList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if(openSet.containsKey(node)){
		    return openList.get(0);
        }
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node) {
        //return openSet.containsKey(node);
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
	    ASearchNode bestNode = openList.remove(0);
	    openSet.remove(bestNode);
	    return bestNode;
	}

}