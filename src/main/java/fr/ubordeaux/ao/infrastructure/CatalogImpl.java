package fr.ubordeaux.ao.infrastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.domain.ReferenceManagementException;
import fr.ubordeaux.ao.domain.Catalog;
import fr.ubordeaux.ao.domain.Reference;
import fr.ubordeaux.ddd.annotations.classes.Repository;

@Repository
public class CatalogImpl implements Catalog {
    private Map<String, Reference> references;

    public CatalogImpl() {
        references = new HashMap<String, Reference>();
    }

    public int size() {
        return references.size();
    }

    public Set<Reference> getReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }
}