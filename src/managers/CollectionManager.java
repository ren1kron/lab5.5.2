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
    private Map<Integer, Worker> map = new LinkedHashMap<>();
//    private Map<Organization, Map<Integer, Worker>> OrganizationMap = new LinkedHashMap<>();
    private Set<Organization> organizations = new HashSet<>();
    private LocalDateTime lastInItTime;
    private LocalDateTime lastSaveTime;

    public Map<Integer, Worker> getMap() {
        return map;
    }

//    public Set<Organization> getOrganizations() {
//        return organizations;
//    }

    public void clearCollection() {
        map.clear();
        organizations.clear();
    }
    public void add(Integer key, Worker worker) {
//        id = max(collection.keySet()) + 1;
        map.put(key, worker);
        worker.getOrganization().EmployeeAdded();
        organizations.add(worker.getOrganization());
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
