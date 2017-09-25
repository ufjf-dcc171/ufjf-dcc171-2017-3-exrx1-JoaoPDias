
package atividadeemsala.eventos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class EventosListModel implements ListModel {
    private List<Evento> eventos;
    private List<ListDataListener> dataListeners;

    public EventosListModel(List<Evento> eventos) {
        this.eventos = eventos;
        this.dataListeners = new ArrayList<>();
    }
    
    
    @Override
    public int getSize() {
        return eventos.size();
    }

    @Override
    public Object getElementAt(int index) {
      return eventos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
