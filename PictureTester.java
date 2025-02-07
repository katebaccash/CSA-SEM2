/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.keepOnlyBlue();
    temple.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.grayscale();
    temple.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.negate();
    temple.explore();
  }
  /** Method to test pixelate */
  public static void testPixelate()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.pixelate(15);
    temple.explore();
  }
   /** Method to test blur */
  public static void testBlur()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    Picture result = temple.blur(13);
    result.explore();
  }
  /** Method to test enhance */
  public static void testEnhance()
  {
    Picture temple = new Picture("images/water.jpg");
    temple.explore();
    Picture result = temple.enhance(9);
    result.explore();
  }
  
  /** Method to test swapLeftRight */
  public static void testSwapLeftRight()
  {
    Picture temple = new Picture("images/beach.jpg");
    temple.explore();
    Picture result = temple.swapLeftRight();
    result.explore();
  }
  
  /** Method to test stairStep */
  public static void testStairStep()
  {
    Picture temple = new Picture("images/beach.jpg");
    temple.explore();
    Picture result = temple.stairStep(15, 7);
    result.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
	//testPixelate();
	//testBlur();
	//testEnhance();
	//testSwapLeftRight();
	testStairStep();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
