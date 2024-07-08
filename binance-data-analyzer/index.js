import instance from "./instance.js";
import { CronJob } from "cron";

const onTickHandler = () => {
  console.log('hehe');
}

const job = new CronJob(
    '* * * * * *',
    onTickHandler,
    null,
    true,
);

job.start();