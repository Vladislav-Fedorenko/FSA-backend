package tld.sld.userApi.web.controllers.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tld.sld.userApi.core.models.DeviceModel;
import tld.sld.userApi.core.repositories.devices.getDevicecByUserId.GetDevicesByUsedIdRepository;
import tld.sld.userApi.web.controllers.models.responses.Response;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetDevicesByUserIdController {
    private GetDevicesByUsedIdRepository getDevicesByUsedIdRepository;

    @Autowired
    public GetDevicesByUserIdController(GetDevicesByUsedIdRepository getDevicesByUsedIdRepository) {
        this.getDevicesByUsedIdRepository = getDevicesByUsedIdRepository;
    }

    @RequestMapping(
            path = "/getDevices",
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResponseEntity<Response<List<DeviceModel>>> getDevicesByUserId(@RequestParam String userId) {
        try {
            final List<DeviceModel> deviceModels = new ArrayList<>();
            getDevicesByUsedIdRepository.get(userId).forEach((entity) -> deviceModels.add(new DeviceModel(entity)));

            return new ResponseEntity<>(
                    new Response<>(true, null, deviceModels),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response<>(true, null, null),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
