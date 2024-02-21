package managers;

import models.Organization;
import models.Worker;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Collections.max;

/**
 * Manages collection
 * @author ren1kron
 */

public class CollectionManager {
//    int id;
    private Map<Integer, Worker> collection = new LinkedHashMap<>();
//    private Set<Organization> organizations = new HashSet<>();
    private LocalDateTime lastInItTime;
    private LocalDateTime lastSaveTime;

    public Map<Integer, Worker> getCollection() {
        return collection;
    }

//    public Set<Organization> getOrganizations() {
//        return organizations;
//    }

    public void clearCollection() {
        collection.clear();
    }
    public void add(Integer key, Worker worker) {
//        id = max(collection.keySet()) + 1;
        collection.put(key, worker);
        worker.getOrganization().EmployeeAdded();
//        organizations.add(worker.getOrganization());
    }

//    public void showCollectionInfo() {
//
//    }

    public LocalDateTime getLastInItTime() {
        return lastInItTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }
}
