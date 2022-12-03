package com.beratyesbek.airlinesChecking.grpcService;

import com.beratyesbek.airlinesChecking.dao.BoughtTicketDao;
import com.beratyesbek.airlinesChecking.models.BoughtTicket;
import com.beratyesbek.grpc.BoughtTicketGrpcServiceGrpc;
import com.beratyesbek.grpc.BoughtTicketRequest;
import com.beratyesbek.grpc.empty;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;

@GrpcService
@AllArgsConstructor
public class BoughtTicketGrpcServiceImpl extends BoughtTicketGrpcServiceGrpc.BoughtTicketGrpcServiceImplBase {

    private final BoughtTicketDao boughtTicketDao;
    private final ModelMapper modelMapper;

    @Override
    public void saveBoughtTicket(BoughtTicketRequest request, StreamObserver<empty> responseObserver) {
        BoughtTicket boughtTicket = modelMapper.map(request, BoughtTicket.class);
        boughtTicketDao.save(boughtTicket);
        super.saveBoughtTicket(request, responseObserver);
    }
}
