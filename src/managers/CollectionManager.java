package managers;

import models.Worker;

import java.time.LocalDateTime;
import java.util.*;


/**
 * Manages collection
 * @author ren1kron
 */

public class CollectionManager {
//    int id;
    private Map<Integer, Worker> keyMap = new LinkedHashMap<>();
    private Map<Integer, Worker> idMap = new LinkedHashMap<>();
//    private Map<Organization, Map<Integer, Worker>> OrganizationMap = new LinkedHashMap<>();
//    private Set<Organization> organizations = new HashSet<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final DumpManager dumpManager;

    public CollectionManager(DumpManager dumpManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.dumpManager = dumpManager;
    }

    /**
     * @return map of workers
     */
    public Map<Integer, Worker> getKeyMap() {
        return keyMap;
    }

    /**
     * @return Worker by their id
     */
    public Worker byId(int id) {
        return idMap.get(id);
    }

//    public Set<Organization> getOrganizations() {
//        return organizations;
//    }

    /**
     * Clears keyMap and idMap
     */
    public void clear() {
        keyMap.clear();
        idMap.clear();
    }

    /**
     * Adds worker to maps
     * @param worker added worker
     */
    public void add(Worker worker) {
//        id = max(collection.keySet()) + 1;
        keyMap.put(worker.getKey(), worker);
        idMap.put(worker.getId(), worker);
//        organizations.add(worker.getOrganization());
//        worker.getOrganization().EmployeeAdded();
    }



//    public void showCollectionInfo() {
//
//    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }
}
