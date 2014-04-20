package jordner.jpa.preferences;

import jordner.jpa.osgi.Activator;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
     * initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        store.setDefault(PreferenceConstants.P_JPA_UNITNAME,
                JPADefaults.JPA_UNIT);
        store.setDefault(PreferenceConstants.P_JDBC_DRIVER, "");
        store.setDefault(PreferenceConstants.P_JDBC_URL, "");
        store.setDefault(PreferenceConstants.P_JDBC_USERNAME, "");
        store.setDefault(PreferenceConstants.P_JDBC_PASSWORD, "");

        store.setDefault(PreferenceConstants.P_JPA_DDL_GENERATION,
                "drop-and-create-tables");
        store.setDefault(PreferenceConstants.P_JPA_DDL_GENERATION_MODE,
                "database");

        store.setDefault(PreferenceConstants.P_JPA_WAEVING, "false");
        store.setDefault(PreferenceConstants.P_JPA_WAEVING_INTERNAL, "false");

        store.setDefault(PreferenceConstants.P_JPA_LOGLEVEL, "FINE");
    }

}
