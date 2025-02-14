package org.czo.droid48sx;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPreferenceScreen(createPreferenceHierarchy());
    }

    private PreferenceScreen createPreferenceHierarchy() {
        // Root
        PreferenceScreen root = getPreferenceManager().createPreferenceScreen(this);
        root.setTitle(R.string.settings);
        PreferenceCategory inlinePrefCat = new PreferenceCategory(this);
        inlinePrefCat.setTitle(R.string.general_preferences);
        root.addPreference(inlinePrefCat);

        CheckBoxPreference savePref = new CheckBoxPreference(this);
        savePref.setKey("saveOnExit");
        savePref.setTitle(R.string.saveonexit_msgbox);
        savePref.setSummary(R.string.saveonexit_msgbox_value);
        savePref.setDefaultValue(true);
        inlinePrefCat.addPreference(savePref);

        CheckBoxPreference hapticPref = new CheckBoxPreference(this);
        hapticPref.setKey("haptic");
        hapticPref.setTitle(R.string.haptic_feedback);
        hapticPref.setSummary(R.string.haptic_feedback_summary);
        hapticPref.setDefaultValue(true);
        inlinePrefCat.addPreference(hapticPref);

        PreferenceCategory inlineDispPrefCat = new PreferenceCategory(this);
        inlineDispPrefCat.setTitle(R.string.display_preferences);
        root.addPreference(inlineDispPrefCat);

        CheckBoxPreference fullScreenPref = new CheckBoxPreference(this);
        fullScreenPref.setKey("fullScreen");
        fullScreenPref.setTitle(R.string.full_screen);
        fullScreenPref.setSummary(R.string.full_screen_summary);
        fullScreenPref.setDefaultValue(false);
        inlineDispPrefCat.addPreference(fullScreenPref);

        CheckBoxPreference largeLCDPref = new CheckBoxPreference(this);
        largeLCDPref.setKey("large_width");
        largeLCDPref.setTitle(R.string.large_width);
        largeLCDPref.setSummary(R.string.large_width_summary);
        largeLCDPref.setDefaultValue(false);
        inlineDispPrefCat.addPreference(largeLCDPref);

        PreferenceCategory portPrefCat = new PreferenceCategory(this);
        portPrefCat.setTitle(R.string.ramcards_preferences);
        root.addPreference(portPrefCat);

        ListPreference port1Pref = new ListPreference(this);
        port1Pref.setEntries(R.array.port_1_entries);
        port1Pref.setEntryValues(R.array.port_1_values);
        port1Pref.setDefaultValue("0");
        port1Pref.setDialogTitle(R.string.ram_install);
        port1Pref.setKey("port1");
        port1Pref.setTitle(R.string.port1_install);
        portPrefCat.addPreference(port1Pref);

        ListPreference port2Pref = new ListPreference(this);
        port2Pref.setEntries(R.array.port_2_entries);
        port2Pref.setEntryValues(R.array.port_2_values);
        port2Pref.setDefaultValue("0");
        port2Pref.setDialogTitle(R.string.ram_install);
        port2Pref.setKey("port2");
        port2Pref.setTitle(R.string.port2_install);
        portPrefCat.addPreference(port2Pref);

        PreferenceCategory buildPrefCat = new PreferenceCategory(this);
        buildPrefCat.setTitle(R.string.build_preferences);
        root.addPreference(buildPrefCat);

        Preference buildPref = new Preference(this);
        buildPref.setTitle(BuildConfig.BUILD_TAG);
        buildPref.setSummary(BuildConfig.BUILD_DATE);
        buildPrefCat.addPreference(buildPref);

        setResult(RESULT_OK);

        return root;
    }
}
