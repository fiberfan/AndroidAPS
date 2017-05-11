package info.nightscout.androidaps.plugins.PumpDanaRv2.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import info.nightscout.androidaps.plugins.PumpDanaR.comm.MessageBase;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgBolusProgress;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgBolusStart;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgBolusStop;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgCheckValue;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgError;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryAlarm;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryAll;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryAllDone;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryBasalHour;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryBolus;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryCarbo;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryDailyInsulin;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryDone;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryError;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryGlucose;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryNew;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryNewDone;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistoryRefill;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgHistorySuspend;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgInitConnStatusBasic;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgInitConnStatusBolus;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgInitConnStatusOption;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgInitConnStatusTime;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgPCCommStart;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgPCCommStop;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetActivateBasalProfile;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetBasalProfile;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetCarbsEntry;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetExtendedBolusStart;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetExtendedBolusStop;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetSingleBasalProfile;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetTempBasalStart;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSetTempBasalStop;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingActiveProfile;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingBasal;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingBasalProfileAll;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingGlucose;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingMaxValues;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingMeal;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingProfileRatios;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingProfileRatiosAll;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingPumpTime;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingShippingInfo;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgSettingUserOptions;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgStatus;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgStatusBasic;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgStatusBolusExtended;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgStatusProfile;
import info.nightscout.androidaps.plugins.PumpDanaR.comm.MsgStatusTempBasal;


/**
 * Created by mike on 28.05.2016.
 */
public class MessageHashTable {
    private static Logger log = LoggerFactory.getLogger(MessageHashTable.class);

    public static HashMap<Integer, MessageBase> messages = null;

    static {
        if (messages == null) {
            messages = new HashMap<Integer, MessageBase>();
            put(new MsgBolusStop());                 // 0x0101 CMD_MEALINS_STOP
            put(new MsgBolusStart());                // 0x0102 CMD_MEALINS_START_DATA
            put(new MsgBolusProgress());             // 0x0202 CMD_PUMP_THIS_REMAINDER_MEAL_INS
            put(new MsgStatusProfile());             // 0x0204 CMD_PUMP_CALCULATION_SETTING
            put(new MsgStatusTempBasal());           // 0x0205 CMD_PUMP_EXERCISE_MODE
            put(new MsgStatusBolusExtended());       // 0x0207 CMD_PUMP_EXPANS_INS_I
            put(new MsgStatusBasic());               // 0x020A CMD_PUMP_INITVIEW_I
            put(new MsgStatus());                    // 0x020B CMD_PUMP_STATUS
            put(new MsgInitConnStatusTime());        // 0x0301 CMD_PUMPINIT_TIME_INFO
            put(new MsgInitConnStatusBolus());       // 0x0302 CMD_PUMPINIT_BOLUS_INFO
            put(new MsgInitConnStatusBasic());       // 0x0303 CMD_PUMPINIT_INIT_INFO
            put(new MsgInitConnStatusOption());      // 0x0304 CMD_PUMPINIT_OPTION
            put(new MsgSetTempBasalStart());         // 0x0401 CMD_PUMPSET_EXERCISE_S
            put(new MsgSetCarbsEntry());             // 0x0402 CMD_PUMPSET_HIS_S
            put(new MsgSetTempBasalStop());          // 0x0403 CMD_PUMPSET_EXERCISE_STOP
            put(new MsgSetExtendedBolusStop());      // 0x0406 CMD_PUMPSET_EXPANS_INS_STOP
            put(new MsgSetExtendedBolusStart());     // 0x0407 CMD_PUMPSET_EXPANS_INS_S
            put(new MsgError());                     // 0x0601 CMD_PUMPOWAY_SYSTEM_STATUS
            put(new MsgPCCommStart());               // 0x3001 CMD_CONNECT
            put(new MsgPCCommStop());                // 0x3002 CMD_DISCONNECT
            put(new MsgHistoryBolus());              // 0x3101 CMD_HISTORY_MEAL_INS
            put(new MsgHistoryDailyInsulin());       // 0x3102 CMD_HISTORY_DAY_INS
            put(new MsgHistoryGlucose());            // 0x3104 CMD_HISTORY_GLUCOSE
            put(new MsgHistoryAlarm());              // 0x3105 CMD_HISTORY_ALARM
            put(new MsgHistoryError());              // 0x3106 CMD_HISTORY_ERROR
            put(new MsgHistoryCarbo());              // 0x3107 CMD_HISTORY_CARBOHY
            put(new MsgHistoryRefill());             // 0x3108 CMD_HISTORY_REFILL
            put(new MsgHistorySuspend());            // 0x3109 CMD_HISTORY_SUSPEND
            put(new MsgHistoryBasalHour());          // 0x310A CMD_HISTORY_BASAL_HOUR
            put(new MsgHistoryDone());               // 0x31F1 CMD_HISTORY_DONT_USED
            put(new MsgSettingBasal());              // 0x3202 CMD_SETTING_V_BASAL_INS_I
            put(new MsgSettingMeal());               // 0x3203 CMD_SETTING_V_MEAL_SETTING_I
            put(new MsgSettingProfileRatios());      // 0x3204 CMD_SETTING_V_CCC_I
            put(new MsgSettingMaxValues());          // 0x3205 CMD_SETTING_V_MAX_VALUE_I
            put(new MsgSettingBasalProfileAll());    // 0x3206 CMD_SETTING_V_BASAL_PROFILE_ALL
            put(new MsgSettingShippingInfo());       // 0x3207 CMD_SETTING_V_SHIPPING_I
            put(new MsgSettingGlucose());            // 0x3209 CMD_SETTING_V_GLUCOSEandEASY
            put(new MsgSettingPumpTime());           // 0x320A CMD_SETTING_V_TIME_I
            put(new MsgSettingUserOptions());        // 0x320B CMD_SETTING_V_USER_OPTIONS
            put(new MsgSettingActiveProfile());      // 0x320C CMD_SETTING_V_PROFILE_NUMBER
            put(new MsgSettingProfileRatiosAll());   // 0x320D CMD_SETTING_V_CIR_CF_VALUE
            put(new MsgSetSingleBasalProfile());     // 0x3302 CMD_SETTING_BASAL_INS_S
            put(new MsgSetBasalProfile());           // 0x3306 CMD_SETTING_BASAL_PROFILE_S
            put(new MsgSetActivateBasalProfile());   // 0x330C CMD_SETTING_PROFILE_NUMBER_S
            put(new MsgHistoryAllDone());            // 0x41F1 CMD_HISTORY_ALL_DONE
            put(new MsgHistoryAll());                // 0x41F2 CMD_HISTORY_ALL
            put(new MsgHistoryNewDone());            // 0x42F1 CMD_HISTORY_NEW_DONE
            put(new MsgHistoryNew());                // 0x42F2 CMD_HISTORY_NEW
            put(new MsgCheckValue());                // 0xF0F1 CMD_PUMP_CHECK_VALUE
            put(new MsgStatusAPS());                 // 0xE001 CMD_PUMP_APS
            put(new MsgSetAPSTempBasalStart());      // 0xE002 CMD_PUMPSET_APSTEMP
            put(new MsgHistoryEvents());             // 0xE003 CMD_HISTORY_EVENTS
            put(new MsgStatusAPSTempBasal());        // 0xE004 CMD_PUMP_APSTEMP
        }
    }

    public static void put(MessageBase message) {
        int command = message.getCommand();
        //String name = MessageOriginalNames.getName(command);
        messages.put(command, message);
        //log.debug(String.format("%04x ", command) + " " + name);
    }

    public static MessageBase findMessage(Integer command) {
        if (messages.containsKey(command)) {
            return messages.get(command);
        } else {
            return new MessageBase();
        }
    }
}
