// ----------------------------------------------------
// Assignment 4
// Part 2
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: April 19, 2020
// Read through a list of cellphone information and create a LinkedList with that information
//-----------------------------------------------------
import java.util.NoSuchElementException;
/**
 * This program uses linked lists, that manipulates a set of records of cell phones and performs some operations on these records.
 * 
 * @author Auvigoo Ahmed (40128901)
 * @author Arafat Atique (40132573)
 * @version 4.12.0
 * @see SubDictionary
 * @see CellListUtilization
 * @see CellPhone
 *
 */
public class CellList {
    //Primitive and object type attributes 
	private CellNode head;
    private int size;
    private int counter=0; //This is a counter that will be used to keep track of iterations
    
    /**
     * This method will return the size of the cell list
     * @return integer Size of the the cell list
     */
    public int getSize() {
        return size;
    }
    /**
     * This method will return the value of the counter 
     * @return interger Value of the counter 
     */
    public int getCtr() {
        return counter;
    }
    /**
     * This is a default constructor for the cell list; it sets the head to null and size to zero.
     */
    public CellList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * This is the copy constructor for the cell list. It will return a deep copy of the passed cell list.
     * @param cellList Object type of cell list
     */
    public CellList(CellList cellList){
        this.head = null;
        this.size = cellList.size;

        CellNode othertemp = cellList.head;
        head = new CellNode(othertemp.getCp(),head);
        CellNode temp = head;

        othertemp = othertemp.next;
        while(othertemp!= null){
            temp.next = new CellNode(new CellPhone(othertemp.getCp(), othertemp.getCp().getSerialNum()),null);
            temp = temp.next;
            othertemp = othertemp.next;
        }
        temp = othertemp = null;
    }
    class CellNode{
        private CellPhone cp = new CellPhone(123111212,"OnePlus",2018,500); //This is an example phone node that will be used 
        private CellNode next;												//for testing purposes
        /**
         * This is the default constructor for the node. It will set the cellphone and next variables to null.
         */
        public CellNode() {
            cp = null;
            next = null;
        }
        /**
         * This is parametrized constructor for the node. It will create a node based on the passed cellphone and next node.
         * @param cp CellPhone object
         * @param next CellNode object
         */
        public CellNode(CellPhone cp, CellNode next) {
            this.cp = cp;
            this.next = next;
        }
        /**
         * This is a copy constructor for the node class. 
         * @param cn CellNode object
         */
        public CellNode(CellNode cn){
            this.cp = cn.getCp();
            this.next = cn.getnext();
        }
        /**
         * This method will return the cellphone object
         * @return CellPhone object 
         */
        public CellPhone getCp() {
            return cp;
        }
        /**
         * This method will set the cellphone 
         * @param cp CellPhone object
         */
        public void setCp(CellPhone cp) {
            this.cp = cp;
        }
        /**
         * This method will return the next node in the linked list
         * @return CellNode object
         */
        public CellNode getnext() {
            return next;
        }
        /**
         * This method will set the next node in the linked list
         * @param next CellNode Object
         */
        public void setnext(CellNode next) {
            this.next = next;
        }

        /**
         * This is the clone method that will make a new node based on the passed cellphone and next node. 
         * It uses the copy constructor. 
         * @return CellNode object
         */
        protected Object clone() {
            return new CellNode((CellPhone)cp.clone(), this.next);
        }
    }
    /**
     * This method will add a cellphone to the start of the linked list 
     * @param cp CellPhone object
     */
    public void addToStart(CellPhone cp){
    	//Verifying if the cellphone already exists or not
        if (find(cp.getSerialNum())==null) {
            head = new CellNode(new CellPhone(cp,cp.getSerialNum()), head);
            size++;
        }
    }
    /**
     * This method will insert a cellphone at the desired index
     * @param cp CellPhone object
     * @param index Integer value of the index
     */
    public void insertAtIndex(CellPhone cp, int index){
        int ctr=0;
        CellNode temp = head;
        //Verifying is the cellphone exists of not
        if (find(cp.getSerialNum())==null) {
            if (index > this.size - 1 || index <0) //Checking the validity of the index
                throw new NoSuchElementException(); //Throws an exception in case of invalid index
            if (index == 0) {
                this.addToStart(new CellPhone(cp,cp.getSerialNum()));
                return;
            }//Navigating to the desired index
            while (temp.next != null && ctr + 1 != index) {
                temp = temp.next;
                ctr++;
            } //Adding the cellphone to the passed index
            temp.next = new CellNode(new CellPhone(cp,cp.getSerialNum()), temp.next);
            size++;
        }
    }
    /**
     * This method will delete a cellphone from the passed index
     * @param index Integer value of index
     */
    public void deleteFromIndex(int index){
        int ctr=0;
        CellNode temp = head;
        if (index > this.size-1 || index <0) //Checking validity of the index
            throw new NoSuchElementException();
        if (index == 0) { //Special case for index = 0
            head = head.next;
            size--;
            return;
        }
        while (ctr+1!=index){
            temp = temp.next;
            ctr++;
        }
        temp.next = temp.next.next;
        size--;
    }
    /**
     * This method will delete the first node of the list
     */
    public void deleteFromStart(){
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    /**
     * This method will replace a node with the passed node at the passed index
     * @param cp CellPhone object
     * @param index Integer value of index
     */
    public void replaceAtIndex(CellPhone cp, int index) {
        if (index > this.size - 1 || index < 0) 
            return;
        if (index == 0){
            head = new CellNode(new CellPhone(cp,cp.getSerialNum()), head.next);
            return;
        }
        CellNode temp = head;
        int ctr = 0;
        while (ctr+1!=index){
            temp = temp.next;
            ctr++;
        }
        temp.next = new CellNode(new CellPhone(cp,cp.getSerialNum()),temp.next.next);
    }

    // This method may result in a privacy leak as it returns a pointer to a specific location in the linked list
    // To avoid privacy leak, make the node class a private inner class in the linked list class
    /**
     * This method will find a cellphone based on the passed serial number 
     * @param sn Long value of serial number
     * @return CellNode object 
     */
    public CellNode find(long sn){
        CellNode temp = head;
        counter = 0;
        while (temp!=null && temp.cp.getSerialNum()!=sn){
            temp = temp.next;
            counter++;
        }
        return temp;
    }
    /**
     * This method will check if the linked list contains a node with the passed serial number 
     * @param sn Long value of serial number 
     * @return boolean 
     */ 
    public boolean contains(long sn){
        CellNode temp = head;
        while (temp!=null && temp.cp.getSerialNum()!=sn){
            temp = temp.next;
        }
        if (temp == null)
            return false;
        return true;
    }
    /**
     * This method will print the linked list.
     */
    public void showContents(){
        CellNode temp = head;
        int ctr = 1;
        System.out.println();
        String s = "The current size of the list is "+this.size+". Here are the contents of the list.\n" +
                "=====================================================================\n";
        while (temp!=null){
            s += temp.cp.toString()+" ---> ";
            temp = temp.next;
            if (ctr%3==0)
                s+="\n";
            ctr++;
        }
        s +="X";
        System.out.println(s);
        System.out.println();
    }
    /**
     * This method checks if two lists are equal. 
     * @param o CellList object
     * @return boolean
     */
    public boolean equals(CellList o) {
        if (o.size == this.size) {
            CellNode temp = head;
            CellNode temp2 = o.head;
            while (temp != null) {
                if (!temp.cp.equals(temp2.cp))
                    return false;
                temp = temp.next;
                temp2 = temp2.next;
            }
            return true;
        } else
            return false;
    }
}