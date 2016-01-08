package pa.iscde.DeepSearchHandler.activator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import extensionpoints.ISearchEvent;
import extensionpoints.ISearchEventListener;
import extensionpoints.Item;


public class SearchHandlerActivator implements BundleActivator, ISearchEventListener {

	private ISearchEvent searchEvent;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("SearchHandlerActivator.start");
		ServiceReference<ISearchEvent> ref_browser = context.getServiceReference(ISearchEvent.class);
		searchEvent = context.getService(ref_browser);
		searchEvent.addListener(this);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		searchEvent.removeListener(this);
	}

	@Override
	public void widgetSelected(String text_Search, String text_SearchInCombo, String specificText_SearchInCombo, String text_SearchForCombo, ArrayList<String> buttonsSelected_SearchForCombo) {
		Collection<String> resultParents = searchEvent.getResultParents();
		for (String resultParent : resultParents) {
			System.out.println(resultParent);
			
			//TODO: FAZER COISAS COM OS RESULTADOS!
		}
		
		
		Map<String, LinkedList<Item>> results = searchEvent.getResults();
		if(!results.isEmpty()){
			for (String key : results.keySet()) {
				System.out.println(key);
				
				LinkedList<Item> list = results.get(key);
				if(!list.isEmpty()){
					for (Item item : list) {
						System.out.println(item.getName());
					}
				}
			}
		}else{
			System.out.println("No search results returned");
		}
		
	}
}
