package com.online.taxi.timingtask;

import com.online.taxi.entity.PassengerWalletFreezeRecord;
import com.online.taxi.mapper.PassengerWalletFreezeRecordMapper;
import com.online.taxi.task.OtherInterfaceTask;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 钱包解冻定时任务
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class PurseThawSchedule {

    @NonNull
    private final PassengerWalletFreezeRecordMapper passengerWalletFreezeRecordMapper;

    @NonNull
    private final OtherInterfaceTask otherInterfaceTask;

    @Scheduled(cron = "0 */2 *  * * ? ")
    private void doEveryMonthJob() {
        Date date = new Date();
        try {
            List<PassengerWalletFreezeRecord> passengerWalletFreezeRecordsList = passengerWalletFreezeRecordMapper.selectPurseThaw(date);
            log.info("待解冻记录：" + JSONArray.fromObject(passengerWalletFreezeRecordsList));
            for (PassengerWalletFreezeRecord passengerWalletFreezeRecord : passengerWalletFreezeRecordsList) {
                log.info("解冻yid:" + passengerWalletFreezeRecord.getPassengerInfoId() + ",orderId:" + passengerWalletFreezeRecord.getOrderId());
                otherInterfaceTask.walletUnfreeze(passengerWalletFreezeRecord.getOrderId(), passengerWalletFreezeRecord.getPassengerInfoId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("定时任务{}发生错误", getClass().getName(), e);
        }
    }
}
