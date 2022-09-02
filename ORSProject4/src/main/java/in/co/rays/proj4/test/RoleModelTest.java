package in.co.rays.proj4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;
/**
 * Role Model Test classes
 *
 * @author Deepraj chouhan
 
 */
public class RoleModelTest {
	 /**
     * Model object to test
     */
	public static RoleModel model = new RoleModel();
	/**
     * Main method to call test methods.
   
     */
	public static void main(String[] args) throws Exception {
		//testAdd();
        //testDelete();
        //testUpdate();
        //testFindByPK();
        //testFindByName();
        //testSearch();
        testList();
	}
	/**
	 * test list of Role
	 */
	public static void testList() throws Exception {
		RoleBean bean = new RoleBean();
		List list = new ArrayList();
		list = model.list(1, 2);
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			 bean = (RoleBean) it.next();
			 System.out.println(bean.getId());
			 System.out.println(bean.getName());
		}
	}
	/**
	 * test search of Role
	 */
	public static void testSearch() throws Exception {
		RoleBean bean = new RoleBean();
		List list = new ArrayList();
		bean.setName("Andhra");
		list = model.search(bean, 1, 1);
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			 bean = (RoleBean) it.next();
			 System.out.println(bean.getValue());
			 System.out.println(bean.getName());
			 System.out.println(bean.getId());
		}
	}
	/**
	 * test findByName of Role
	 */
	public static void testFindByName() throws Exception {
		RoleBean bean = model.findByName("Andhra");
		System.out.println(bean.getName());
		System.out.println(bean.getId());
		System.out.println("testFindByName");
		
	}
	/**
	 * test findByPk of Role
	 */
	public static void testFindByPK() throws Exception {
		RoleBean bean = model.findByPK(3);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println("testFindByPK success");
	}
	/**
	 * test update of Role
	 */
	public static void testUpdate() throws DuplicateRecordException, DatabaseException, ApplicationException {
		RoleBean bean = model.findByPK(3);
		bean.setName("Andhra");
		bean.setDescription("Pradesh");	
		
			model.update(bean);
           System.out.println("test updated success");
		
	}
	/**
	 * test delete of Role
	 */
	public static void testDelete() {
		try {
			RoleBean bean = new RoleBean();
			long id = 4;
			bean.setId(id);
		
			model.delete(bean);
			
			RoleBean deletedbean = model.findByPK(id);
            if (deletedbean != null) {
                System.out.println("Test Delete fail");
            }
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	/**
	 * test add of Role
	 */
	public static void testAdd() {
		RoleBean bean = new RoleBean();
		bean.setName("Arshdeep");
		bean.setDescription("Raj");
		
		try {
			long pk = model.add(bean);
			
			RoleBean addedbean = model.findByPK(pk);
            if (addedbean == null) {
                System.out.println("Test add failed");
            }
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
