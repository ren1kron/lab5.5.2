package managers;

import models.Worker;

import java.time.LocalDateTime;
import java.util.*;


/**
 * Manages collection
 * @author ren1kron
 */

public class CollectionManager {
    private int currentId = 1;
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

    @Deprecated
    public int maxId() {
        return Collections.max(idMap.keySet());
    }


    // TODO сделать так, чтобы id получался здесь и вводился методом в InsertCommand
    /**
     * Finds free ID
     * @return Free ID
     */
    public int getFreeId() {
        while (byId(currentId) != null)
            if (++currentId < 0)
                currentId = 1;
        return currentId;
    }
    public Worker byKey(Integer key) {
        return keyMap.get(key);
    }

    public boolean isContain(Worker worker) {
        return worker == null || byId(worker.getId()) != null;
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

//    public boolean isContain(Worker worker) {
//        return worker == null || byId(worker.getId()) != null;
//    }

    /**
     * Adds worker to maps
     * @param worker added worker
     */
    public boolean add(Worker worker) {
//        id = max(collection.keySet()) + 1;
        if (isContain(worker)) return false;
        keyMap.put(worker.getKey(), worker);
        idMap.put(worker.getId(), worker);
        return true;
//        organizations.add(worker.getOrganization());
//        worker.getOrganization().EmployeeAdded();
    }

    /**
     * Updates value of worker
     * @param worker new worker with same id
     * @return true if worker updated successfully
     */
    public boolean update(Worker worker) {
        if (!isContain(worker)) return false;
        keyMap.put(worker.getKey(), worker);
        idMap.put(worker.getId(), worker);

        return true;
    }

    /**
     * Removes worker from maps by its key
     * @param key worker's key
     * @return true if worker was successfully removed
     and false if worker was never found
     */
    public boolean removeByKey(Integer key) {
        var worker = byKey(key);
        if (worker == null) return false;
        keyMap.remove(key);
        idMap.remove(worker.getId());
        return true;
    }

    /**
     * Downloads collection from file
     * @return true if collection was downloaded successfully
     */
    public boolean init() {
        idMap.clear();
        keyMap.clear();
        dumpManager.readCsv(keyMap);
        lastInitTime = LocalDateTime.now();
        for (var e : keyMap.values()) {
            if (byId(e.getId()) != null) {
                keyMap.clear();
                idMap.clear();
//                throw new RuntimeException();
                return false;
            } else {
                idMap.put(e.getId(), e);
            }
        }
        return true;
    }

    /**
     * Saves collection to file
     */
    public void saveMap() {
        dumpManager.writeCsv(keyMap);
        lastSaveTime = LocalDateTime.now();
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
