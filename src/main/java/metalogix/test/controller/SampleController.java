package metalogix.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import metalogix.test.domain.AccountAgg;
import metalogix.test.domain.Sample;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Tag(name = "SampleController", description = "the Sample controller Api")
@RequestMapping("/api")
public class SampleController {
    public SampleController() {
    }

    @Operation(
            summary = "Fetch all account",
            description = "fetches all account entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/account")
    public ResponseEntity<Sample.SampleAccount[]> getSampleAccount() {
        System.out.println("RETRIEVING Sample account");

        return ResponseEntity.ok().body(Sample.SAMPLE_ACCOUNTS);
    }

    @Operation(
            summary = "Add  account",
            description = "Add Account with result all account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
    @PostMapping("/account")
    public ResponseEntity<List<Sample.SampleAccount>> addSampleAccount(@RequestBody Sample.SampleAccount account) {
        System.out.println("SAVE Sample account: "+ account);

        List<Sample.SampleAccount> sampleAccounts = Arrays.stream(Sample.SAMPLE_ACCOUNTS)
                .collect(Collectors.toList());

        if(sampleAccounts.stream().anyMatch(v -> v.getSampleName().equals(account.getSampleName()))) {
            return ResponseEntity.badRequest().body(null);
        }

        sampleAccounts.add(account);


        return ResponseEntity.created(URI.create("/api/account")).body(sampleAccounts);
    }



    @Operation(
            summary = "Update  account",
            description = "update Account with result all account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/account")
    public ResponseEntity<List<Sample.SampleAccount>> updateSampleAccount(@RequestBody Sample.SampleAccount account) {
        System.out.println("UPDATE Sample account: "+ account);
        List<Sample.SampleAccount> sampleAccounts = Arrays.stream(Sample.SAMPLE_ACCOUNTS)
                .collect(Collectors.toList());

        if(sampleAccounts.stream().noneMatch(v -> v.getSampleName().equals(account.getSampleName()))) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Sample.SampleAccount> sampleAccount = sampleAccounts.stream().filter(v -> v.getSampleName().equals(account.getSampleName())).findFirst();

        int idx = 0;

        for (int i = 0; i < sampleAccounts.size(); i++) {
            if(sampleAccounts.get(i).getSampleName().equals(sampleAccount.get().getSampleName())) {
                idx = i;
                break;
            }
        }

        sampleAccounts.remove(idx);
        sampleAccounts.add(account);




        return ResponseEntity.ok().body(sampleAccounts);
    }


    @Operation(
            summary = "delete  account by sample name",
            description = "delete Account with result all account after delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/account/{sampleName}")
    public ResponseEntity<List<Sample.SampleAccount>> deleteSampleAccount(@PathVariable String sampleName) {
        System.out.println("DELETE Sample account: "+ sampleName);
        List<Sample.SampleAccount> sampleAccounts = Arrays.stream(Sample.SAMPLE_ACCOUNTS)
                .collect(Collectors.toList());

        if(sampleAccounts.stream().noneMatch(v -> v.getSampleName().equals(sampleName))) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Sample.SampleAccount> sampleAccount = sampleAccounts.stream().filter(v -> v.getSampleName().equals(sampleName)).findFirst();

        int idx = 0;

        for (int i = 0; i < sampleAccounts.size(); i++) {
            if(sampleAccounts.get(i).getSampleName().equals(sampleAccount.get().getSampleName())) {
                idx = i;
                break;
            }
        }

        sampleAccounts.remove(idx);

        return ResponseEntity.ok().body(sampleAccounts);
    }

    @Operation(
            summary = "get  balance aggregate parent>>sub>>sub sub account>>etc",
            description = "balance aggregate with parent>>sub>>sub sub account>>etc")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/balance/aggregate/{sampleName}/{parentAccountNo}")
    public ResponseEntity<AccountAgg> getBalanceAggregate(@PathVariable String sampleName, @PathVariable String parentAccountNo) {
        if(sampleName == null ||parentAccountNo == null ) {
            return ResponseEntity.badRequest().body(null);
        }


        if(Arrays.stream(Sample.SAMPLE_ACCOUNTS).noneMatch(v -> v.getSampleName().equals(sampleName))) {
            return ResponseEntity.badRequest().body(null);
        }

        Sample.SampleAccount sampleAccount = Arrays.stream(Sample.SAMPLE_ACCOUNTS)
                .filter(v -> v.getSampleName().equals(sampleName))
                .findFirst().get();



        List<Sample.Account> accounts = Arrays.stream(sampleAccount.getAccounts()).collect(Collectors.toList());


        List<AccountAgg> accountAggs = accountAgg(accounts, parentAccountNo);

        AccountAgg accountAgg = new AccountAgg();
        accountAgg.setAccountNo(parentAccountNo);
        accountAgg.setChilds(accountAggs);

        return ResponseEntity.ok().body(accountAgg);

    }

    public static  List<AccountAgg> accountAgg(List<Sample.Account> accounts, String parentNo) {

        List<AccountAgg> accountAggs = new ArrayList<>();

        List<Sample.Account> accountsC = accounts.stream().filter(v -> v.getParentAccountNo().equals(parentNo)).collect(Collectors.toList());

        if(accountsC.isEmpty()) {
            return null;
        } else {

            for (Sample.Account account:  accountsC) {
                AccountAgg accountAgg = new AccountAgg();
                accountAgg.setAccountNo(account.getAccountNo());
                accountAgg.setBalance(account.getBalance());
                accountAgg.setChilds(accountAgg(accounts, accountAgg.getAccountNo()));

                accountAggs.add(accountAgg);
            }
        }

        return  accountAggs;
    }
}
