/**
 * This class represents the manual of the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Notebook
{
    //instance variables
    private Page[] pages;
    private int curPage;    // first page is 1
    /**
    * This Constructor initializes the Page Array and the Current page variable
    */
    public Notebook ()
    {
        pages = new Page[5];
        curPage = 1;
        int j;
        for (j = 0; j < pages.length; j++)
            pages[j] = new Page (j + 1);
    }
    /**This method sets the content of the current page to the parameter
    @param content info to be set*/
    public void writeOnPage (String content)
    {
        pages[curPage - 1].setContent (content);
    }
    /**This method returns the info on the current page
    @return content info in the current page*/
    public String retrieveContent ()
    {
        return pages[curPage - 1].getContent ();
    }
    /**This method increments the curPage variable if the condition is met*/
    public void nextPage ()
    {
        if (!isAtLastPage ())
            curPage++;
    }
    /**This method decrements the curPage variable if the condition is met*/
    public void prevPage ()
    {
        if (!isAtFirstPage ())
            curPage--;
    }
    /**This method checks if curPage == 1 or if the notebook is on the first page*/
    public boolean isAtFirstPage ()
    {
        return curPage == 1;
    }
    /**This method checks if curPage == pages.length or if the notebook is on the last page*/
    public boolean isAtLastPage ()
    {
        return curPage == pages.length;
    }
    /**This method returns curPage
    @return current page number*/
    public int getCurrentPageNo ()
    {
        return curPage;
    }
    /**This method returns how many pages the notebook has
    @return notebook capacity/length*/
    public int getNumberOfPages ()
    {
        return pages.length;
    }
    
    @Override
    /**This method returns what page the notebook is at
    @return current page out of notebook capacity*/
    public String toString ()
    {
        return "at Page " + curPage + " of " + pages.length;
    }
}
