/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse223.block.controller;

// line 23 "../../../../../Block223TransferObjects.ump"
public class TOGridCell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TOGridCell Attributes
  private int gridHorizontalPosition;
  private int gridVerticalPosition;
  private int id;
  private int red;
  private int green;
  private int blue;
  private int points;
  private int blastRadius;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TOGridCell(int aGridHorizontalPosition, int aGridVerticalPosition, int aId, int aRed, int aGreen, int aBlue, int aPoints, int aBlastRadius)
  {
    gridHorizontalPosition = aGridHorizontalPosition;
    gridVerticalPosition = aGridVerticalPosition;
    id = aId;
    red = aRed;
    green = aGreen;
    blue = aBlue;
    points = aPoints;
    blastRadius = aBlastRadius;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGridHorizontalPosition(int aGridHorizontalPosition)
  {
    boolean wasSet = false;
    gridHorizontalPosition = aGridHorizontalPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setGridVerticalPosition(int aGridVerticalPosition)
  {
    boolean wasSet = false;
    gridVerticalPosition = aGridVerticalPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setRed(int aRed)
  {
    boolean wasSet = false;
    red = aRed;
    wasSet = true;
    return wasSet;
  }

  public boolean setGreen(int aGreen)
  {
    boolean wasSet = false;
    green = aGreen;
    wasSet = true;
    return wasSet;
  }

  public boolean setBlue(int aBlue)
  {
    boolean wasSet = false;
    blue = aBlue;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public boolean setBlastRadius(int aBlastRadius)
  {
    boolean wasSet = false;
    blastRadius = aBlastRadius;
    wasSet = true;
    return wasSet;
  }

  public int getGridHorizontalPosition()
  {
    return gridHorizontalPosition;
  }

  public int getGridVerticalPosition()
  {
    return gridVerticalPosition;
  }

  public int getId()
  {
    return id;
  }

  public int getRed()
  {
    return red;
  }

  public int getGreen()
  {
    return green;
  }

  public int getBlue()
  {
    return blue;
  }

  public int getPoints()
  {
    return points;
  }

  public int getBlastRadius()
  {
    return blastRadius;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "gridHorizontalPosition" + ":" + getGridHorizontalPosition()+ "," +
            "gridVerticalPosition" + ":" + getGridVerticalPosition()+ "," +
            "id" + ":" + getId()+ "," +
            "red" + ":" + getRed()+ "," +
            "green" + ":" + getGreen()+ "," +
            "blue" + ":" + getBlue()+ "," +
            "points" + ":" + getPoints()+ "," +
            "blastRadius" + ":" + getBlastRadius()+ "]";
  }
}